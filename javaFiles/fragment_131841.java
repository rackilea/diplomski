SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy,HH:mm");

Date date = format.parse("01-23-2012,09:40");
System.out.println(date);

format.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println(format.format(date));