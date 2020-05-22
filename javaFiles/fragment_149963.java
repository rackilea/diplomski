public void showNotification() {
 Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
 NotificationManager nMN = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
 Notification n  = new Notification.Builder(this)
 .setContentTitle("Notification Title")
 .setContentText("Notification content")
 .setSmallIcon() //set your icon
 .setVibrate(new long[] { 1000, 1000 })
 .setLights(Color.BLUE, 700, 500)
 .setSound(alarmSound)
 .setOngoing(true)
 //.setStyle(new NotificationCompat.BigTextStyle(NorProv))
 .build();
 nMN.notify(NOTIFICATION_ID, n);
}