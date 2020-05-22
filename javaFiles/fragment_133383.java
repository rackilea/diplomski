Calendar calendarDate = Calendar.getInstance();
calendarDate.setTime(date);

Calendar calendarTime = Calendar.getInstance();
calendarTime.setTime(time);

Calendar calendarDateTime = Calendar.getInstance();

calendarDateTime.set(Calendar.YEAR, calendarDate.get(Calendar.YEAR));
calendarDateTime.set(Calendar.MONTH, calendarDate.get(Calendar.MONTH));
calendarDateTime.set(Calendar.DAY_OF_MONTH, calendarDate.get(Calendar.DAY_OF_MONTH));
calendarDateTime.set(Calendar.HOUR, calendarTime.get(Calendar.HOUR));
calendarDateTime.set(Calendar.MINUTE, calendarTime.get(Calendar.MINUTE));
calendarDateTime.set(Calendar.SECOND, calendarTime.get(Calendar.SECOND));
calendarDateTime.set(Calendar.MILLISECOND, calendarTime.get(Calendar.MILLISECOND));

Date dateTime = calendarDateTime.getTime();