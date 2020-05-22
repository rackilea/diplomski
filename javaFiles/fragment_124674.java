// parse both formats (use optional section, delimited by [])
DateTimeFormatter parser = DateTimeFormatter.ofPattern("[MM/dd/yyyy][yyyy-MM-dd'T'HH:mm:ss]");

// parse MM/dd/yyyy
LocalDate d1 = LocalDate.parse("10/16/2016", parser);
// parse yyyy-MM-dd'T'HH:mm:ss
LocalDate d2 = LocalDate.parse("2016-10-16T10:20:30", parser);

// parser.format(d1) is the same as d1.format(parser)
System.out.println(parser.format(d1));
System.out.println(parser.format(d2));