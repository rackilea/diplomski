DateTimeFormatter fmt = new DateTimeFormatterBuilder()
        .appendPattern("uuuu[-MM[-dd]]")
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .parseDefaulting(ChronoField.SECOND_OF_DAY, 0)
        .toFormatter(Locale.US)
        .withZone(ZoneId.of("America/New_York"));
System.out.println(fmt.parse("2019-08-13", Instant::from)); // 2019-08-13T04:00:00Z
System.out.println(fmt.parse("2019-08"   , Instant::from)); // 2019-08-01T04:00:00Z
System.out.println(fmt.parse("2019"      , Instant::from)); // 2019-01-01T05:00:00Z