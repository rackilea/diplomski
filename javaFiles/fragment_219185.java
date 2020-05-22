Date indate     = new Date("21-Nov-2011");

Calendar cal1 = Calendar.getInstance();     
cal1.setTime(indate);   

// set the time zone same as server time zone.  
cal1.setTimeZone(TimeZone.getTimeZone("GMT"));

// then clear out the rest in oder to get only the date.
cal1.set(Calendar.HOUR, 0);
cal1.set(Calendar.MINUTE, 0);
cal1.set(Calendar.SECOND, 0);