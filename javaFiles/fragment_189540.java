NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(activity)
                .setSmallIcon(R.drawable.ic_launcher_background) // notification icon
                .setContentTitle("Notification!") // title for notification
                .setContentText("Hello word") // message for notification
                .setAutoCancel(true); // clear notification after click
Intent intent = new Intent(activity, RecorderActivity.class);
PendingIntent pi = PendingIntent.getActivity(activity,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
mBuilder.setContentIntent(pi);
notificationManager.notify(1, mBuilder.build());