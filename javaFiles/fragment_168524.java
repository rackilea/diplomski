public static final int REQUEST_CODE_NOTIFY = 1;

public void scheduleNotification(long delayTimeMs) {
    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    long currentTimeMs = SystemClock.elapsedRealtime();

    PendingIntent pendingNotifyIntent = PendingIntent.getBroadcast(
            this,
            REQUEST_CODE_NOTIFY,
            new Intent(NotifyHandlerReceiver.ACTION),
            PendingIntent.FLAG_UPDATE_CURRENT);
    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, currentTimeMs + delayTimeMs, pendingNotifyIntent);
}