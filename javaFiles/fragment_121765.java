public class TaskScheduler {
    PendingIntent mPendingIntent;
    AlarmManager mAlarmManager;

    public static void startScheduling(Context context) {
            Intent intent = new Intent(context, MyReceiver.class);
            mPendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            mAlarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            mAlarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 600, pendingIntent);
    }

    public static void stopScheduling() {
       mAlarmManager.cancel(mPendingIntent);
    }
}