SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
sdfDate.setTimeZone(java.util.TimeZone.getTimeZone("IST"));

SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss a");
sdfTime.setTimeZone(java.util.TimeZone.getTimeZone("IST"));

String dateStr = sdfDate.format(date);
String timeStr = sdfTime.format(date);