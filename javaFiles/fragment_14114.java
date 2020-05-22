// First convert the String to a Date
String dateTime = "2013-11-12 13:14:15";
SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ITALIAN);
Date date = dateParser.parse(dateTime);
// Then convert the Date to a String, formatted as you dd/MM/yyyy
SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
System.out.println(dateFormatter.format(date));