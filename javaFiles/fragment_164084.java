Time time; // you have this from your Database query
DateTime dateTime; // you have this already or will create a new one

Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(time.getTime());
dateTime.setTime(calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));