Intent intent = new Intent (this, AlarmBroadcastReceiver.class);
    PendingIntent pendIntent = PendingIntent.getBroadcast(this, 1,  intent, PendingIntent.FLAG_UPDATE_CURRENT);
    AlarmManager alarmManager = (AlarmManager) getSystemService (Context.ALARM_SERVICE);
    alarmManager.cancel(pendIntent); //cancel if active already
    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis()+600000,
            600000, pendIntent);