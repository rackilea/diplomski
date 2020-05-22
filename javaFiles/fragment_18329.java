DateTimeFormatter parser =
    new DateTimeFormatterBuilder()
        .appendValue(ChronoField.YEAR, 4)
        .optionalStart()
        .appendPattern("MM[dd]")
        .optionalEnd()
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .toFormatter();

System.out.println(parser.parse("2014", LocalDate::from)); // 2014-01-01
System.out.println(parser.parse("201411", LocalDate::from)); // 2014-11-01
System.out.println(parser.parse("20141130", LocalDate::from)); // 2014-11-30