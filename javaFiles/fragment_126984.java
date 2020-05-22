private void sendNotification(String msg) {
    mNotificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);

    Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://your-website.com"));
    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setContentTitle("Big4Com").setSmallIcon(R.drawable.notification_icon).setStyle(new NotificationCompat.BigTextStyle().bigText(msg)).setContentText(msg);

    mBuilder.setContentIntent(contentIntent);
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
}