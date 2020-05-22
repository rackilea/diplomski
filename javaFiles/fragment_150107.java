NotificationCompat.Builder mBuilder = new  
NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.your_drawable)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("notification text"))
                    .setContentText(notificationToNotify.getText())
                    .setContentTitle(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "notification title"))
                    .setContentIntent(contentPendingIntent)
                    .setDeleteIntent(deletePendingIntent)
                    .setAutoCancel(true);

            //notify the Notification
            mNotifyMgr.notify(notification_id, mBuilder.build());