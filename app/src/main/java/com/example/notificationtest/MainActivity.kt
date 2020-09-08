package com.example.notificationtest

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 =
                NotificationChannel("channel1", "channel1", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel1)
            val channel2 =
                NotificationChannel("channel2", "channel2", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
            val channel3 =
                NotificationChannel("channel3", "channel3", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel3)
            val channel4 =
                NotificationChannel("channel4", "channel4", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel4)
        }
        show_notification1.setOnClickListener {
            val intent = Intent(this, TargetActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "channel1")
                .setContentTitle("This is title")
                .setContentText("This is text")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.boy))
                .build()
            manager.notify(1, notification)
        }

        show_notification2.setOnClickListener {
            val intent = Intent(this, TargetActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "channel2")
                .setContentTitle("This is title")
                .setContentText("this is text")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.boy))
                .setAutoCancel(true)
                .setContentIntent(pi)
                .build()
            manager.notify(2, notification)
        }

        show_notification3.setOnClickListener {
            val intent = Intent(this, TargetActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "channel3")
                .setContentTitle("this is title")
                .setContentText("this is text")
                .setStyle(
                    NotificationCompat.BigTextStyle().bigText(
                        "科怀·伦纳德（Kawhi Leonard），" +
                                "1991年6月29日出生于美国加利福尼亚州河边市，美国职业篮球运动员，司职小前锋，" +
                                "效力于NBA洛杉矶快船队。"
                    )
                )
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.boy))
                .build()
            manager.notify(3, notification)
        }

        show_notification4.setOnClickListener {
            val intent = Intent(this, TargetActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "channel3")
                .setContentIntent(pi)
                .setContentTitle("this is title")
                .setContentText("this is text")
                .setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(resources, R.mipmap.boy))
                )
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.boy))
                .setAutoCancel(true)
                .build()
            manager.notify(4, notification)
        }
    }
}