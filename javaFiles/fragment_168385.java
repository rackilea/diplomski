Intent intent = new Intent(this, Receiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0); //Or you can get broadcast in your way.
int seconds = 25;
Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.SECOND, seconds);
alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);