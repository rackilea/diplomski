String input = "20130507";
String format = "yyyyMMdd";

SimpleDateFormat df = new SimpleDateFormat(format);
Date date = df.parse(input);

Calendar cal = Calendar.getInstance();
cal.setTime(date);
int week = cal.get(Calendar.WEEK_OF_YEAR);