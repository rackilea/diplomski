Duration d = new Duration(100000000L); // in milliseconds
Period p = d.toPeriodFrom(new DateTime(), PeriodType.yearWeekDayTime());
PeriodFormatter f = ISOPeriodFormat.alternateExtendedWithWeeks();
String s = f.print(p);
System.out.println(s); 
// P0000-W00-01T03:46:40 (one day, 3 hours, 46 minutes and 40 secs)