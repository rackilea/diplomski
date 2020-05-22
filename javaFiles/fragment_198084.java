Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
Date now = new Date();
calendar.setTime(now);

//today
day = date.get(Calendar.DAY_OF_MONTH);
month = date.get(Calendar.MONTH);
year = date.get(Calendar.YEAR);


calendar.setTimeInMillis(12345678765L);


day = date.get(Calendar.DAY_OF_MONTH);
month = date.get(Calendar.MONTH);
year = date.get(Calendar.YEAR);