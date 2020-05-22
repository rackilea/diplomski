long unixSeconds = Long.valueOf(submit_time.substring(0,10)).longValue();
Date date = new Date(unixSeconds*1000L);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
String formattedDate = sdf.format(date);
String timestampYear = formattedDate.substring(1,4);
String timestampMonth = formattedDate.substring(6,7);
String timestampDay = formattedDate.substring(9,10);