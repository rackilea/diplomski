Calendar alarmCalendar = Calendar.getInstance();
alarmCalendar.set(Calendar.MONTH, month);
alarmCalendar.set(Calendar.HOUR_OF_DAY, hour);
alarmCalendar.set(Calendar.MINUTE, minute);

Intent alarm_on = new Intent(this, MainTaskAlarmReciever.class);

alarm_on.putExtra("extra", "alarm on");

pendingIntent = PendingIntent.getBroadcast(this, 0, alarm_on, PendingIntent.FLAG_UPDATE_CURRENT);

mAlarmManager.set(AlarmManager.RTC_WAKEUP, alarmCalendar.getTimeInMillis(), pendingIntent);