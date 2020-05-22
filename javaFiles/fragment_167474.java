private void showNotification(String message){

        Log.d("Hay8","DCM8");
        Intent intent = new Intent(context, MapsActivity.class);
        Log.d("Hay9","DCM9");
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("Hay10","DCM10");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"default")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notification1")
                .setContentText(message)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);
        Log.d("Hay11","DCM11");



        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Log.d("Hay12","DCM12");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId("com.myApp");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "com.myApp",
                    "My App",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
        notificationManager.notify(2,builder.build());
    }