DateTime dateTime; // you have this already

Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(0); // set to zero epoch
calendar.set(Calendar.HOUR, dateTime.getHours());
calendar.set(Calendar.MINUTE, dateTime.getMinutes());
calendar.set(Calendar.SECOND, dateTime.getSeconds());

Time time = new Time(calendar.getTimeInMillis());