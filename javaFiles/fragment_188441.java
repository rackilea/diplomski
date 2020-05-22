Locale.setDefault(Locale.UK);
String storedDateString = "Sun Jul 10 17:47:55 EDT 2011";
SimpleDateFormat dateParser = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

Date storedDate = dateParser.parse(storedDateString);

GregorianCalendar storedCal = new GregorianCalendar();
storedCal.setTime(storedDate);
GregorianCalendar currentCal = new GregorianCalendar();

int storedDayOfYear = storedCal.get(Calendar.DAY_OF_YEAR);
int currentDayofYear = currentCal.get(Calendar.DAY_OF_YEAR);

//int storedDayYear = storedCal.get(Calendar.YEAR);
//int currentDayYear = storedCal.get(Calendar.YEAR);

System.out.println(storedDayOfYear);
System.out.println(currentDayofYear);

//System.out.println(storedDayYear);
//System.out.println(currentDayYear);