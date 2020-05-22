Calendar cal = Calendar.getInstance();
cal.set(Calendar.YEAR, year);
cal.set(Calendar.MONTH, monthOfYear);
cal.set(Calendar.DATE, dayOfMonth);
cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
cal.set(Calendar.MINUTE, minute);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
Date date = cal.getTime();