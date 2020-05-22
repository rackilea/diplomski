// Get Current Time 
Calendar currentTime = GregorianCalendar.getInstance();

// While Alarm Time in the past, fast forward a day
while (alarmTime.before(currentTime)) {
    alarmTime.add(Calendar.DAY_OF_YEAR, 1);
}