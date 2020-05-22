Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
calendar.set(Calendar.MINUTE, minute);

if(calendar.before(Calendar.getInstance())) {
    calendar.add(Calendar.DATE, 1);
}

alarmManager.set(AlarmManager.RTC_WAKEUP,
    calendar.getTimeInMillis(), pendingDinnerIntent);