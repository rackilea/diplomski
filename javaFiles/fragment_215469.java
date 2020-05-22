TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // Just for testing

final long TIME_IN_MILL = 1563204600000L; // 2019-07-15 15:30 UTC

Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(TIME_IN_MILL);
int hour = cal.get(Calendar.HOUR_OF_DAY);
int minute = cal.get(Calendar.MINUTE);
cal.setTimeInMillis(System.currentTimeMillis()); // Reset
cal.set(Calendar.HOUR_OF_DAY, hour);
cal.set(Calendar.MINUTE, minute);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);

System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(cal.getTime()));