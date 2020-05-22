// By default lenient behaviour with overflow of 24:00 to next day
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
GregorianCalendar gcal = new GregorianCalendar(2014, Calendar.AUGUST, 17, 0, 0, 0);
gcal.set(Calendar.HOUR_OF_DAY, 24);
System.out.println("HOUR_OF_DAY: " + gcal.get(Calendar.HOUR_OF_DAY)); // 0
System.out.println(sdf.format(gcal.getTime())); // 2014-08-14 00:00

// now switch to strict mode    
gcal.setLenient(false);
gcal.set(Calendar.HOUR_OF_DAY, 24);
gcal.getTime(); // triggers recomputation which will fail with following abort
// abort relates to set()-method => java.lang.IllegalArgumentException: HOUR_OF_DAY