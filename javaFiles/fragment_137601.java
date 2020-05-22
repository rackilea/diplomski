public long getIntervalTimeForFormat(String formatPattern, TimeZone timezone, Locale locale, Date inputDate){
  Date someOddestDate = new Date(1318352124368L);
  GregorianCalendar calendar = new GregorianCalendar();
  calendar.setTime(someOddestDate);
  GregorianCalendar calendarInput = new GregorianCalendar();
  calendarInput.setTime(inputDate);
  Date reducedDate = null;
try {
    SimpleDateFormat formatter = new SimpleDateFormat(formatPattern, locale);
    formatter.setTimeZone(timezone);
    reducedDate = formatter.parse(formatter.format(someOddestDate));
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
  GregorianCalendar reducedCalendar = new GregorianCalendar();
  reducedCalendar.setTime(reducedDate);
  int maxField = 0;
  int i = 14;
//    System.out.println("Reduced date is "+DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.GERMAN).format(reducedDate)+" - Oddest date is "+DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.GERMAN).format(someOddestDate));
  while(i > 0 &&  maxField == 0){
//        System.out.println("Reduced Field "+i+" is set "+reducedCalendar.isSet(i)+" and has value "+reducedCalendar.get(i)+" with actual maximum "+   reducedCalendar.getActualMaximum(i)+" and minimum "+reducedCalendar.getActualMinimum(i)+"-> "+reducedCalendar.getDisplayName(i, DateFormat.FULL, Locale.UK));
//        System.out.println("Oddest date Field "+i+" is set "+calendar.isSet(i)+" and has value "+calendar.get(i)+" with actual maximum "+ calendar.getActualMaximum(i)+" and minimum "+calendar.getActualMinimum(i)+"-> "+calendar.getDisplayName(i, DateFormat.FULL, Locale.UK));
      if(reducedCalendar.get(i) == calendar.get(i)){
//            System.out.println("-------> Field "+i+" is equal.");
          maxField = i;
      }
      i--;
  }
  long valueInMillis = Long.MIN_VALUE;
  switch(maxField){
    case 1: valueInMillis = calendarInput.getActualMaximum(6) * 24L * 60 * 60 * 1000; break;// current year granularity
    case 2: valueInMillis = calendarInput.getActualMaximum(5) * 24L * 60 * 60 * 1000; break;// current month granularity
    case 3: //week in month // we just want to know that the granularity is week here and don't care about partial weeks
    case 4: valueInMillis = 7 * 24L * 60 * 60 * 1000; break; // week in year
    case 5: //day granularity
    case 6:
    case 7:
    case 8: valueInMillis = 24L * 60 * 60 * 1000; break; 
    case 9: valueInMillis = 12L * 60 * 60 * 1000; break; //half a day
    case 10: //hour
    case 11: valueInMillis = 60 * 60 * 1000; break; 
    case 12: valueInMillis = 60 * 1000; break; //minute
    case 13: valueInMillis = 1000; break; //second
    case 14: valueInMillis = 1; break; //millisecond
    default: System.err.println("This should never happen.");
  }
//    System.out.println("Returning "+valueInMillis);
return valueInMillis;