java.text.SimpleDateFormat sourceFormat = new SimpleDateFormat("z");

java.text.SimpleDateFormat gmtFormat = new SimpleDateFormat("'GMT('ZZZ')' zzzz");

java.util.Date date1 = sourceFormat.parse("IST");

TimeZone gmtTime = TimeZone.getTimeZone("IST");

gmtFormat.setTimeZone(gmtTime);

//System.out.println("Source date: " + date1);

System.out.println("   "+ gmtFormat.format(date1));