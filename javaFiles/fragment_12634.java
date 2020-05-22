DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd HH:mm:ss")
    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
    .toFormatter();

System.out.println(LocalDateTime.parse("2015-05-07 13:20:22.276052", formatter));
System.out.println(LocalDateTime.parse("2015-05-07 13:20:22.276", formatter));
System.out.println(LocalDateTime.parse("2015-05-07 13:20:22", formatter));

// output
2015-05-07T13:20:22.276052
2015-05-07T13:20:22.276
2015-05-07T13:20:22