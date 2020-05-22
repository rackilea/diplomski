void updateNotification(String text) {
Log.i(TAG, text);


Intent n = new Intent(getApplicationContext(), MainActivity.class):
n.putExtra("key", yourValue);
PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,
        n),
        PendingIntent.FLAG_UPDATE_CURRENT);

notification.setLatestEventInfo(getApplicationContext(), "nikhil", text, pi);
notificationManager.notify(NOTIFICATION_ID, notification);
}