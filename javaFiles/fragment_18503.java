// Create the calendar and set the date.
Calendar calendar = new GregorianCalendar();
calendar.setTime(date);

// Set the hours, minutes, etc. to 0.
calendar.set(Calendar.HOUR, 0);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
calendar.set(Calendar.MILLISECOND, 0);
calendar.set(Calendar.AM_PM, Calendar.AM);

long dayDate = calendar.getTime();