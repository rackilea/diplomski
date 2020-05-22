//initialize the Scanner
Scanner scanner = new Scanner(System.in);
//read the desired input
String dateAsString = scanner.next();
//create an instance of SimpleDateFormat
//MM: month (2 digits)
//dd: day (2 digits)
//yyyy: year (four digits)
//more of this in the javadoc
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//parse the String as a Date
Date desiredDate = sdf.parse(dateAsString);
//Calendar.getInstance() should return a GregorianCalendar instance by "default"
Calendar calendar = Calendar.getInstance();
//setting the date into the Calendar
calendar.setTime(desiredDate);