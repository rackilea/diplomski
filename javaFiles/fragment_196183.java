DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // pattern for day/hour
    .appendPattern("EEE MMM dd HH:mm:ss ")
    // UTC offset
    .appendOffset("+HHMM", "UTC")
    // year
    .appendPattern(" yyyy")
    // create formatter
    .toFormatter(Locale.ENGLISH);
System.out.println(fmt.format(converted));