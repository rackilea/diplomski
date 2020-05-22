DateFormat dfParse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
dfParse.setTimeZone(TimeZone.getTimeZone("UTC"));
DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
java.util.Date dateTime ;
dateTime = dfParse.parse(text);
String s= df.format(dateTime);