AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

Intent i= new Intent(context, AlarmManagerBroadcastReceiver.class);

//intent.putExtra(something you want to put);

PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);

Calendar calendar = Calendar.getInstance();

calendar.setTimeInMillis(System.currentTimeMillis());

// check if it is more than 11 am. if so set alarm for next day

if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
    calendar.add(Calendar.DAY_OF_YEAR, 1);
}

// everyday at 11 am
calendar.set(Calendar.HOUR_OF_DAY, 9);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);


am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
        AlarmManager.INTERVAL_DAY, pi);
// alarm set