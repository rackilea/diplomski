public static Timestamp convertStringToTimestamp(String strDate) {      
    String format = "dd/MM/yyyy";
    if(strDate.contains("-")) {
        format = "yyyy-MM-dd";
    }
    DateTimeFormatter DATE_TME_FORMATTER =  
        new DateTimeFormatterBuilder().appendPattern(format)
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
        .toFormatter();
    LocalDate dt = LocalDate.parse(strDate.substring(0, 10), DATE_TME_FORMATTER);
    Timestamp timestamp = Timestamp.valueOf(dt.atStartOfDay());
    return timestamp;
}