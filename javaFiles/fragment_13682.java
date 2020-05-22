// sdf contains a Calendar object with the default timezone.
Date date = new Date();
String formatPattern = ....;
SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);

TimeZone T1;
TimeZone T2;
....
....
// set the Calendar of sdf to timezone T1
sdf.setTimeZone(T1);
System.out.println(sdf.format(date));

// set the Calendar of sdf to timezone T2
sdf.setTimeZone(T2);
System.out.println(sdf.format(date));

// Use the 'calOfT2' instance-methods to get specific info
// about the time-of-day for date 'date' in timezone T2.
Calendar calOfT2 = sdf.getCalendar();