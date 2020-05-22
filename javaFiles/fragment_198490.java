private void registerAlarm(Context context, int requestCode) {
    int HOUR = 60 * 60 * 1000;
    Intent intent = new Intent(context, DailyAlarmReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
            + 24 * HOUR, pendingIntent);
}