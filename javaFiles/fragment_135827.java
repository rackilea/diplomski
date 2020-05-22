createNotificationChannel();
 Notification notification = new NotificationCompat.Builder(this, "channelID")
              .setSmallIcon(R.drawable.notification_icon)
              .setContentTitle("My notification")
              .setContentText("Much longer text that cannot fit one line...")
              .build();


 private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel serviceChannel = new NotificationChannel(
                "channelID",
                "Channel Name",
                importance
        );

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(serviceChannel);
    }
}