public static void startAlarmBroadcastReceiver(Context context) {
    Intent _intent = new Intent(context, AlarmBroadcastReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, _intent, 0);
    AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.cancel(pendingIntent);
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 0);
    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
}