final Intent launcherIntent = new Intent();
final PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launcherIntent, 0);
final Notification.Builder builder = new Notification.Builder(this)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle("Test Notification")
        .setWhen(System.currentTimeMillis())
        .setContentIntent(pendingIntent);
final Notification notification;
if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
    notification = builder.build();
}
else {
    //noinspection deprecation
    notification = builder.getNotification();
}
this.startForeground(NOTIFICATION_ID, notification);