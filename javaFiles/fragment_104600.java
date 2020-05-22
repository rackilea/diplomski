public static String addTrailingZerosToTimestamp(String timeStamp) {
    DateTimeFormatter truncatedFormatter = new DateTimeFormatterBuilder()
            .appendPattern("uuuu-MM-dd['T'HH[:mm[:ss[.SSSSSS]]]]")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
            .toFormatter();
    DateTimeFormatter desiredFormatter 
            = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSS");
    LocalDateTime dateTime = LocalDateTime.parse(timeStamp, truncatedFormatter);
    return dateTime.format(desiredFormatter);
}