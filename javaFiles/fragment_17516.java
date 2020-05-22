java.sql.Date myDate = Date.valueOf("2011-04-11");
Calendar calendarDate = Calendar.getInstance();

//normalise the SQL date 
//http://download.oracle.com/javase/6/docs/api/java/sql/Date.html
calendarDate.set(Calendar.HOUR_OF_DAY, 0);
calendarDate.set(Calendar.MINUTE, 0);
calendarDate.set(Calendar.SECOND, 0);
calendarDate.set(Calendar.MILLISECOND, 0);

calendarDate.setTime(myDate);

calendarDate.set(Calendar.DST_OFFSET, 0); //Clear the daylight savings offset
calendarDate.set(Calendar.ZONE_OFFSET, 0); //Clear the timezone offset