DateTimeFormatter f = new DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd HH")
        .appendFraction(ChronoField.MINUTE_OF_HOUR, 0, 6, true)
        .appendOffsetId()
        .toFormatter();
    OffsetDateTime dt = OffsetDateTime.of(2017, 3, 21, 5, 28, 59, 0, ZoneOffset.UTC);
    System.out.println(dt); // 2017-03-21T05:28:59Z
    System.out.println(dt.format(f)); // 2017-03-21 05.466666Z

    OffsetDateTime dt2 = OffsetDateTime.of(2017, 3, 21, 5, 28, 0, 0, ZoneOffset.UTC);
    System.out.println(dt2); // 2017-03-21T05:28Z
    System.out.println(dt2.format(f)); // 2017-03-21 05.466666Z