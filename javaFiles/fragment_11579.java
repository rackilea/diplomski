public class BackgroundService extends IntentService {
    private static final int REQUEST_CODE = 42;
    private static final String ACTION_CANCEL_NOTIFS = "CancelNotifications";

    public BackgroundService() {
        super("BackgroundService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null && ACTION_CANCEL_NOTIFS.equals(intent.getAction())) {
            NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationmanager.cancelAll();
        }
        else {
            reschedule();
        }
    }

    private void reschedule() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MINUTE, 15);

        final Intent serviceIntent = new Intent(this, getClass());
        serviceIntent.setAction(ACTION_CANCEL_NOTIFS);
        PendingIntent pendingIntent = PendingIntent.getService(this, REQUEST_CODE, serviceIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}