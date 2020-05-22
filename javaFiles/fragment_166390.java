Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(System.currentTimeMillis());
calendar.set(Calendar.SECOND, 0);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.HOUR, 0);
calendar.set(Calendar.AM_PM, Calendar.AM);
calendar.add(Calendar.DAY_OF_MONTH, 1); 

AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, service);