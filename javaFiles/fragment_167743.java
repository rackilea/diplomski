//String to Date conversion
String startTimeStr = "2014-06-11"; 
SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd"); 
Date d = simpleFormat.parse(startTimeStr);
//Date to Timestamp conversion
Calendar cal = Calendar.getInstance();
cal.setTime(d);
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 1);
Timestamp startTimestamp = new Timestamp(cal.getTime().getTime());