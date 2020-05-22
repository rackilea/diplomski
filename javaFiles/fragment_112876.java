Calendar calNotif = Calendar.getInstance();
Intent alertIntent = new Intent(this, NotificationReceiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 102, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT);
AlarmManager notifAlarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN)
notifAlarm.setExact(AlarmManager.RTC_WAKEUP, calNotif.getTimeInMillis()+10000, pendingIntent);
else 
notifAlarm.set(AlarmManager.RTC_WAKEUP, calNotif.getTimeInMillis()+10000, pendingIntent);