@Override
public void onCreate() {
    super.onCreate();
    // Do initialization or whatever here (executed once per service lifecycle)
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    if (intent.getAction().equals("start")) {
        // Register your listener or whatever
        showForegroundNotification();
    }
    if (intent.getAction().equals("stop")) {
        // Unregister your listener or whatever
        stopForeground(true);
        stopSelf();
    }

    return START_STICKY;
}

private void showForegroundNotification() {
    Intent myServiceNotificationIntent = new Intent(this, MainActivity.class);
    myServiceNotificationIntent.setFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    PendingIntent pendingIntent = PendingIntent
            .getActivity(this, MY_SERVICE_REQUEST_CODE,
                    myServiceNotificationIntent, MY_SERVICE_FLAG);

    Notification notification = new NotificationCompat.Builder(this)
            .setContentTitle(MY_SERVICE_NOTIFICATION_CONTENT_TITLE)
            .setTicker(MY_SERVICE_NOTIFICATION_TICKER)
            .setContentText(MY_SERVICE_NOTIFICATION_CONTENT_TEXT)
            .setSmallIcon(R.drawable.ic_whatever)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .build();
    startForeground(MY_SERVICE_NOTIFICATION_ID, notification);
}