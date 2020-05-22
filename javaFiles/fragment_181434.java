String fullTime = "2016-03-23 18:08:59";
DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
           df2 = new SimpleDateFormat("HH:mm");
df1.setTimeZone(TimeZone.getTimeZone("UTC"));
df2.setTimeZone(TimeZone.getTimeZone("IST"));
String timeStr = "";
try {
    timeStr = df2.format(df1.parse(fullTime)); //parse throws ParseException
} catch (ParseException e) { /* handle this */ }