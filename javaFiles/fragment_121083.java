Calendar cal = Calendar.getInstance();
// Here I use the time retrieved from the DB
cal.setTimeInMillis(time);
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
// Here I use the time zone id retrieved from the DB
TimeZone tz = TimeZone.getTimeZone(timeZoneId);
formatter.setTimeZone(tz);
System.out.printf("The current time in %s is %s%n",  id, formatter.format(cal.getTime()));