Notification notification = new NotificationCompat.Builder(context, "default")
        .setDefaults(Notification.DEFAULT_ALL)
        .setWhen(System.currentTimeMillis())
        .setSmallIcon(R.mipmap.ic_launcher_round)
        .setContentTitle("It's time")
        .setContentText("Time to training")
        .setContentInfo("Info")
        .build();
manager.notify(1, notification);