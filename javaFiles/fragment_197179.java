Intent intent = new Intent(this, RepeatingAlarmReceiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadcast(context, REQUEST_CODE, intent, 0);

AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5 * 1000), 10 * 1000, pendingIntent);
Toast.makeText(this, "Alarm set", Toast.LENGTH_LONG).show();