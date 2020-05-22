Calendar cal = new GregorianCalendar();
cal.set(2018, 0, 1);
int h = 0;

cal.set(Calendar.HOUR_OF_DAY, h);
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
String date1 = df.format(cal.getTime());
Log.e(TAG, "date1 = " + date1)

cal.set(Calendar.HOUR, h);
TimeZone tzone = TimeZone.getTimeZone("GMT");
cal.setTimeZone(tzone);
String date2 = df.format(cal.getTime());
Log.e(TAG, "date2 GMT = " + date2)