Calendar cal = Calendar.getInstance();
long now = cal.getTimeInMillis();

cal.setTimeInMillis(TIME_IN_MILL);
int hour = cal.get(Calendar.HOUR_OF_DAY);
int minute = cal.get(Calendar.MINUTE);

cal.setTimeInMillis(now);
cal.set(Calendar.HOUR_OF_DAY, hour);
cal.set(Calendar.MINUTE, minute);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);