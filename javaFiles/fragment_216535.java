private void setAlarmManager() {
    Intent intent = new Intent(this, AlarmReceiver.class);
    PendingIntent sender = PendingIntent.getBroadcast(this, 2, intent, 0);
    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
    long l = new Date().getTime();
    if (l < new Date().getTime()) {
        l += 86400000; // start at next 24 hour
    }
    am.setRepeating(AlarmManager.RTC_WAKEUP, l, 86400000, sender); // 86400000
}