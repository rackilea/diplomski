String s = "2013-01-16T13:43:11";
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
df.setTimeZone(TimeZone.getTimeZone("GMT"));
Date date = df.parse(s);
date = new Date(date.getTime() + 5 * 3600 * 1000);
String time = new SimpleDateFormat("HH:mm").format(date);