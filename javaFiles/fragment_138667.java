// today    
Calendar date = new GregorianCalendar();
// reset hour, minutes, seconds and millis
date.set(Calendar.HOUR_OF_DAY, 0);
date.set(Calendar.MINUTE, 0);
date.set(Calendar.SECOND, 0);
date.set(Calendar.MILLISECOND, 0);

// next day
date.add(Calendar.DAY_OF_MONTH, 1);