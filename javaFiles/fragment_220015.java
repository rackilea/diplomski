Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, hour.getHour());
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
calendar.set(Calendar.AM_PM, Calendar.AM);
calendar.add(Calendar.DATE, daysCount); // Add daysCount days to current date