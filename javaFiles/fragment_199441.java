private void showNotification(String message){

    NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"default")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Notification Title")
            .setContentText(message)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent);

    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        builder.setChannelId("YOUR_PACKAGE_NAME");
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel(
                "YOUR_PACKAGE_NAME",
                "YOUR_APP_NAME",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }
    notificationManager.notify(NOTIFICATION_ID,builder.build());
}