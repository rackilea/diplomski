DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
fromFormat.setLenient(false);
DateFormat toFormat = new SimpleDateFormat("dd-MM-yyyy");
toFormat.setLenient(false);
String dateStr = "2011-07-09";
Date date = fromFormat.parse(dateStr);
System.out.println(toFormat.format(date));