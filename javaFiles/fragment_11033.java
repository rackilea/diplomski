//instantiates a calendar using the current time in the specified timezone
Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//change the timezone
cSchedStartCal.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
//get the current hour of the day in the new timezone
cSchedStartCal.get(Calendar.HOUR_OF_DAY);