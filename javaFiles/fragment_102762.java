Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, date);
cal.set(Calendar.MONTH, month-1);//it starts from 0
cal.set(Calendar.YEAR, year);
cal.set(Calendar.HOUR, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
Date result = cal.getTime();