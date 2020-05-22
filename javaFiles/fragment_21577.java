String dateStr = "Jul 16, 2013 12:08:59 AM";
SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a", Locale.ENGLISH);
df.setTimeZone(TimeZone.getTimeZone("UTC"));
Date date = df.parse(dateStr);
df.setTimeZone(TimeZone.getDefault());
String formattedDate = df.format(date);