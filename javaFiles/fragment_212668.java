public static void setAlarm(Context context)
{
    Intent intent = new Intent(context, AlarmReceiver.class);
    intent.setAction("com.Rani.app.SET_NOTIFICATION_ALARM");

    boolean alarmUp = (PendingIntent.getBroadcast(context,
            0, intent, PendingIntent.FLAG_NO_CREATE) != null);

    // check if an alarm already exists
    if (alarmUp == false)
    {
        // set an alarm in case there isnt one already set
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Calendar dailyCheckTime = Calendar.getInstance();
        dailyCheckTime.set(Calendar.HOUR_OF_DAY, 12);
        dailyCheckTime.set(Calendar.MINUTE, 30);
        if (dailyCheckTime.getTimeInMillis() < Calendar.getInstance()
                .getTimeInMillis()) {
            dailyCheckTime.set(Calendar.DATE,
                    dailyCheckTime.get(Calendar.DATE) + 1);
        }

        AlarmManager alarm = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP,
                dailyCheckTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}