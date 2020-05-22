String dateStr = "2017101800000700";
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // date/time
    .appendPattern("yyyyMMddHHmmss")
    // milliseconds (with 2 digits)
    .appendValue(ChronoField.MILLI_OF_SECOND, 2)
    // create formatter
    .toFormatter();
System.out.println(LocalDateTime.parse(dateStr, fmt)); // 2017-10-18T00:00:07