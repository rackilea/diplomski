Calendar cal = Calendar.getInstance();
cal.setTime(yourDate);
cal.set(Calendar.HOUR, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
Date desiredDate = cal.getTime();