function setalarm()
{
 Intent intent = new Intent(getBaseContext(), Intent_Service.class);
       PendingIntent sender = PendingIntent.getBroadcast(getBaseContext(), 192837, intent, PendingIntent.FLAG_UPDATE_CURRENT);
       Random randomGenerator = new Random();
     long interval=60000;  //1 minute in milliseconds
     AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
       am.setRepeating(AlarmManager.RTC, cal.getTimeInMillis(),interval,sender);
}