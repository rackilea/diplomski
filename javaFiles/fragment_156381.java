String input = "2018-04-02 20:06:42";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// use the timezone name. Example: "UTC", "America/New_York", "Europe/Berlin", etc
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

Date date = sdf.parse(input);
// difference in milliseconds
long diffFromNow = System.currentTimeMillis() - date.getTime();