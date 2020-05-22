String dateTime = "1307011200"; // 12:00PM 01 July 2013
dateTime += " EST"; // append the timezone information to the input string
System.out.println("Input -> " + dateTime);
SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmm z"); // tell the formatter to look for the timezone info
Date date = format.parse(dateTime);
System.out.println("Intermediate -> " + date);
format.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println("Output -> " + format.format(date));