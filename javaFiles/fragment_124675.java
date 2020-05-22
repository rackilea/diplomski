// parser/formatter for month/day/year
DateTimeFormatter mdy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
// parser for both patterns
DateTimeFormatter parser = new DateTimeFormatterBuilder()
    // optional MM/dd/yyyy
    .appendOptional(mdy)
    // optional yyyy-MM-dd'T'HH:mm:ss (use built-in formatter)
    .appendOptional(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    // create formatter
    .toFormatter();

// parse MM/dd/yyyy
LocalDate d1 = LocalDate.parse("10/16/2016", parser);
// parse yyyy-MM-dd'T'HH:mm:ss
LocalDate d2 = LocalDate.parse("2016-10-16T10:20:30", parser);

// use mdy to format
System.out.println(mdy.format(d1));
System.out.println(mdy.format(d2));

// format object with time fields: using mdy formatter to avoid multiple pattern problem
System.out.println(mdy.format(LocalDateTime.now()));