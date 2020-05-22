if (!appSettings.isAlarmSetUp()) {
    final AlarmManager am = (AlarmManager) context.getSystemService(ALARM_SERVICE);
    final Intent i = new Intent(context, CustomService.class);
    final Intent intentNotRepeat = new Intent(context, CustomService.class);
    final PendingIntent pi = PendingIntent.getService(context, 0, i, 0);

    am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + AlarmManager.INTERVAL_HALF_HOUR, AlarmManager.INTERVAL_DAY, pi);

    appSettings.setAlarmSetUp(true);
}