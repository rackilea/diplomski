public void setRepeatingAlarm()
{

     Intent intent = new Intent(this, ReceiveAlarm.class);
      PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
        intent, PendingIntent.FLAG_CANCEL_CURRENT);
      am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
        (*time_in_milis to repeat*), pendingIntent);
}