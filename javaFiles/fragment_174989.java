Calendar calendar = Calendar.getInstance();

calendar.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
Date america = calendar.getTime();

calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
Date shanghai = calendar.getTime();

System.out.println(america.equals(shanghai)); // true