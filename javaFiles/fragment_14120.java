Notification notification = new NotificationCompat.Builder(this, "channel01")
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Test")
        .setContentText("You see me!")
        .setDefaults(Notification.DEFAULT_ALL)
        .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
        .build();

NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
notificationManager.notify(0, notification);