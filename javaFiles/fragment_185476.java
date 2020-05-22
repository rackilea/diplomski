Calendar calendar = new GregorianCalendar(2014, Calendar.OCTOBER, 31); // 10/31/2014
// [...]
int lastMonth = (calendar.get(Calendar.MONTH) -1); // lastMonth will be Calendar.SEPTEMBER
calendar.set(Calendar.MONTH, lastMonth); // internal value of the calendar is now 09/31/2014
// [..]
System.out.println("calendar.getActualMaximum(Calendar.DAY_OF_MONTH) : " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // returns 31 because this is a get() method, so 09/31/2014 will be converted to 10/01/2014, and there are 31 days in October (but the internal representation of the calendar will still be 09/31/2014)
// [...]
calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // internal representation is still 09/31/2014, so this will not change the value
// [...]
return formatedDate.format(calendar.getTime()); // this is a get() method, so the value will be converted to 10/01/2014