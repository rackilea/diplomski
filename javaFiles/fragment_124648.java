SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.ENGLISH);
Date date1 = df.parse("01-SEP-17 10:00:00");
Date date2 = df.parse("05-SEP-17 12:00:00");

// get the difference in hours
long dateDiff = TimeUnit.MILLISECONDS.toHours(date2.getTime() - date1.getTime());