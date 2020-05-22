Calendar cal = Calendar.getInstance();
cal.clear();

cal.set(Calendar.YEAR, dtDate.getYear());
cal.set(Calendar.MONTH, dtDate.getMonth());
cal.set(Calendar.DAY_OF_MONTH, dtDate.getDay());

cal.set(Calendar.HOUR_OF_DAY, dtTime.getHours());
cal.set(Calendar.MINUTE, dtTime.getMinutes());
cal.set(Calendar.SECOND, dtTime.getSeconds());

Date date = cal.getTime();