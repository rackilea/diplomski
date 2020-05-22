public class Alarm extends BroadcastReceiver
{
    private static boolean sAlarmCanceled = false;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (sAlarmCanceled)
            return;


        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);
        Toast.makeText(context, "Alarm !!!!!!!!!!", Toast.LENGTH_SHORT).show();
        scheduleNextAlarm(context);
    }

    public static void enableAlarm(Context context) {
        sAlarmCanceled = false;
        scheduleNextAlarm(context);
    }

    public static void disableAlarm() {
        sAlarmCanceled = true;
    }

    private static void scheduleNextAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_ONE_SHOT);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 10000, pi);
    }
}