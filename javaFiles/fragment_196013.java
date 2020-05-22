@TargetApi(26)
private void createNotificationChannel(NotificationManager notificationManager){
    android.app.NotificationChannel channel = new android.app.NotificationChannel(
            NOTIFICATION_CHANNEL_ID, "ID_CHANNEL", NotificationManager.IMPORTANCE_LOW);

    channel.setShowBadge(false);
    channel.enableLights(true);
    channel.setLockscreenVisibility(android.app.Notification.VISIBILITY_PUBLIC);

    notificationManager.createNotificationChannel(channel);
}

public void init(Context context){
   NotificationManager notificationManager = (NotificationManager) context
        .getSystemService(Context.NOTIFICATION_SERVICE);

   //Build.VERSION_CODES.O is not defined in older version of Android
   //So, I have to use a numeric value (26)
   //My Build.VERSION.SDK_INT = 21 (Lollipop)
   if (Build.VERSION.SDK_INT >= 26) {   
      createNotificationChannel(notificationManager); 
   }
}