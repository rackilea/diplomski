DateTimeFormatter fmt = new DateTimeFormatterBuilder()
        .appendValue(ChronoField.YEAR, 4)
        .optionalStart()
        .appendLiteral('-')
        .appendValue(ChronoField.MONTH_OF_YEAR, 2)
        .optionalStart()
        .appendLiteral('-')
        .appendValue(ChronoField.DAY_OF_MONTH, 2)
        .optionalEnd()
        .optionalEnd()
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .toFormatter(Locale.US);
System.out.println(LocalDate.parse("2019-08-13", fmt)); // Prints: 2019-08-13
System.out.println(LocalDate.parse("2019-08"   , fmt)); // Prints: 2019-08-01
System.out.println(LocalDate.parse("2019"      , fmt)); // Prints: 2019-01-01