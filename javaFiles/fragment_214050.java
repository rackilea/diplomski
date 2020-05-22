TimeZone tz = TimeZone.getTimeZone("Asia/Calcutta");
Calendar cal = Calendar.getInstance(tz);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
sdf.setCalendar(cal);
cal.setTime(sdf.parse("2013-07-17T03:58:00.000Z"));
Date date = cal.getTime();