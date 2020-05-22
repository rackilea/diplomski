Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("UTC+3"));
cal1.setTime(yourDate);
Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
cal2.clear();
cal2.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
cal2.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
cal2.set(Calendar.DATE, cal1.get(Calendar.DATE));
cal2.set(Calendar.HOUR_OF_DAY, cal1.get(Calendar.HOUR_OF_DAY));
//simile for whatever level of field precision is needed
Date shiftedDate = cal2.getTime();