SimpleDateFormat df = new SimpleDateFormat();

Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+4:00"));

df.setTimeZone(cal1.getTimeZone());
System.out.println(df.format(cal1.getTime()));

Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("GMT-3:00"));

df.setTimeZone(cal2.getTimeZone());
System.out.println(df.format(cal2.getTime()));