SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
Date date = sdf.parse("2014-02-15 05:18:08");

SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
sdf2.setTimeZone(TimeZone.getTimeZone("IST"));
String dateStr = sdf2.format(date); // Output: 15-02-2014 10:48:08 AM