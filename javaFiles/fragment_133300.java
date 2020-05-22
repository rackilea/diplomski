System.out.println( 
  LocalDate.parse("2015 1", 
    new DateTimeFormatterBuilder().appendPattern("YYYY w")
    .parseDefaulting(WeekFields.ISO.dayOfWeek(), 1)
    .toFormatter()));
// output: 2014-12-29