DateTimeFormatter dtf = 
  new DateTimeFormatterBuilder()
  .appendPattern("yyyyMMddHHmmssSS")
  .appendValue(ChronoField.MILLI_OF_SECOND, 2)
  .toFormatter();
String input = "2011120312345655"; 
LocalDateTime.parse(input, dtf); // abort