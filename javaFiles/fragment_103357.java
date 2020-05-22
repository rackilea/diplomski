String channelIdOreo = "FfffffF";

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

    //region Oreo otification
    Notification notification = new Notification.Builder(context, channelIdOreo)
            .setContentTitle(contentTitleText)
            .setContentText(contentContentText)
            .setNumber(1)
            .setSmallIcon(whiteLogo)
            .setBadgeIconType(whiteLogo)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build();
    //endregion

    NotificationChannel mChannel = new NotificationChannel(channelIdOreo, "Channel human readable title and stuff", NotificationManager.IMPORTANCE_DEFAULT);

    mChannel.enableLights(true);
    mChannel.setLightColor(Color.YELLOW);

    //region Conditions from settings
    if (sNotifications.equals("true")) {
        mChannel.setSound(uri, null);
    } else {
        mChannel.setSound(null, null);
    }

    if (sVibration.equals("true")) {
        mChannel.setVibrationPattern(new long[]{1000, 1000, 1000, 1000, 1000});
    } else {
        mChannel.enableVibration(false);
    }
    //endregion

    if (notificationManager != null) {
        notificationManager.createNotificationChannel(mChannel);
    }
    if (notificationManager != null) {
        notificationManager.notify(notificationCode, notification);
    }
}