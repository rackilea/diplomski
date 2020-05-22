public class SyncAlarm extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent data) {

    // set alarm to start service
    Calendar calendar = new GregorianCalendar();
    calendar.setTimeInMillis(System.currentTimeMillis());

    Calendar cal = new GregorianCalendar();
    cal.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR));
    cal.set(Calendar.HOUR_OF_DAY,  calendar.get(Calendar.HOUR_OF_DAY));

    // start service after an hour
    cal.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 60);
    cal.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
    cal.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND));
    cal.set(Calendar.DATE, calendar.get(Calendar.DATE));
    cal.set(Calendar.MONTH, calendar.get(Calendar.MONTH));

    // set alarm to start service again after receiving broadcast
    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(context, SyncAlarm.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
    am.cancel(pendingIntent);
    am.set(AlarmManager.RTC, cal.getTimeInMillis(), pendingIntent);

    intent = new Intent(context, Reminder.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startService(intent);
    }
}