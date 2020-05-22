DateTimeFormatter format = new DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
    .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true)
    .toFormatter();
LocalDateTime date1 = LocalDateTime.parse("2019-09-17T23:38:47", format).withNano(0);
LocalDateTime date2 = LocalDateTime.parse("2019-09-17T23:38:47.342", format).withNano(0);
System.out.println(date1);
System.out.println(date2);