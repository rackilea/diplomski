//future date
Calendar thatDay = Calendar.getInstance();
thatDay.set(Calendar.HOUR_OF_DAY, hour.getHour());
thatDay.set(Calendar.MINUTE, 0);
thatDay.set(Calendar.SECOND, 0);
thatDay.set(Calendar.AM_PM, Calendar.AM);
thatDay.set(Calendar.DAY_OF_WEEK, Calendar.Monday);

//current date
Calendar newDay = Calendar.getInstance();

long diff = thatDay.getTimeInMillis() - newDay.getTimeInMillis(); //result in millis

//result in days
long days = diff / (24 * 60 * 60 * 1000);