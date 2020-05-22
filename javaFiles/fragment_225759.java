// January 2st 2009
LocalDate dt = LocalDate.of(2009, 1, 2);
System.out.println(dt.get(WeekFields.ISO.weekBasedYear())); // 2009
System.out.println(dt.get(WeekFields.ISO.weekOfWeekBasedYear())); // 1
// WeekFields.ISO and IsoFields are equivalent
System.out.println(dt.get(IsoFields.WEEK_BASED_YEAR)); // 2009
System.out.println(dt.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)); // 1