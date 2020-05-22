builder.setPriority(Notification.PRIORITY_HIGH).setContentIntent(notifIntent)
        .setSmallIcon(R.drawable.ic_android_black_24dp)
        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_android_black_24dp))
        .setTicker(msgAlert)
        .setWhen(System.currentTimeMillis())
        .setContentTitle(msg)
        .setContentText(msgText);