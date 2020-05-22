Calendar rel_calender = new GregorianCalendar();

     rel_calender.set(Calendar.HOUR_OF_DAY, 17);
     rel_calender.set(Calendar.MINUTE, 00);
     rel_calender.set(Calendar.SECOND, 00);
     rel_calender.get(Calendar.HOUR);

     rel_calender.setTimeZone(TimeZone.getTimeZone(rel_timezone));