public void alarm(int time, int requestCode){
    Intent intent = new Intent(MainActivity.this, Alarm.class);

    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
    PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), requestCode , intent, 0);
    am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+time*1000, pi);
}