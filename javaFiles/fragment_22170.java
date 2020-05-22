String d1 = "Wed May 18 00:00:00 CDT 2011";
String d2 = "May. 18, 2011";

SimpleDateFormat d1Formatter = new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy");
SimpleDateFormat d2Formatter = new SimpleDateFormat("MMMM. dd, yyyy");

Date date1 = d1Formatter.parse(d1);
Date date2 = d2Formatter.parse(d2);

date1.equals(date2);