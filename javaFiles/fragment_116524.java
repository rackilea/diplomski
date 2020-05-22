DateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");

Date d = format.parse("28-Feb-2014 13:00:00 PST");
System.out.println(format.format(d));

format.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println(format.format(d));