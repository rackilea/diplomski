DateFormat df1 = new SimpleDateFormat("MMMM, dd yyyy HH:mm:ss Z");
Date date = df1.parse(PUNCH_TIME);

DateFormat df2 = new SimpleDateFormat("HH:mm a 'on' dd/MM/yyyy");
df2.setTimeZone(TimeZone.getTimeZone("UTC"));
String result = df2.format(date);

System.out.println(result);