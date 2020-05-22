Notification.Builder builder = new Notification.Builder(context);
    builder.setContentIntent(pendingIntent)
        .setSmallIcon(R.drawable.ic_launcher)
        .setTicker("My Ticker")
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS)
        .setLights(0xff00ff00, 300, 100) // To change Light Colors
        .setContentTitle("My Title 1")
        .setContentText("My Text 1");
    Notification notification = builder.getNotification();