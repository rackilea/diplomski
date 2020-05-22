DateTimeFormatter fmt = new DateTimeFormatterBuilder()
        .appendPattern("uuuu[-MM[-dd]]")
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .parseDefaulting(ChronoField.SECOND_OF_DAY, 0)
        .toFormatter(Locale.US)
        .withZone(ZoneId.of("America/New_York"));
System.out.println(ZonedDateTime.parse("2019-08-13", fmt)); // 2019-08-13T00:00-04:00[America/New_York]
System.out.println(ZonedDateTime.parse("2019-08"   , fmt)); // 2019-08-01T00:00-04:00[America/New_York]
System.out.println(ZonedDateTime.parse("2019"      , fmt)); // 2019-01-01T00:00-05:00[America/New_York]