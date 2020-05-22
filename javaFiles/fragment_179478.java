SimpleDateFormat formatter = new SimpleDateFormat(/** TODO: Enter your pattern here */);
String dateInString = "Sat May 07 04:31:14 MST 2016";

try {
  Date date = formatter.parse(dateInString);
  System.out.println(date);
  System.out.println(formatter.format(date));
}
catch (ParseException e) {
  e.printStackTrace();
}