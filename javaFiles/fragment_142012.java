public   String convertDateFormatJ8(String format) {
    String retFormat = "ddMMyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy_dd_MM][yyyy-MM-dd HH:mm]");
    try {
        LocalDateTime localDate = LocalDateTime.parse(format, formatter);
        return localDate.format(DateTimeFormatter.ofPattern(retFormat));
    } catch (DateTimeParseException ex) {
        System.err.println("impossible to parse to yyyy-MM-dd HH:mm");
    }
    try {
        LocalDate localDate = LocalDate.parse(format, formatter);
        return localDate.format(DateTimeFormatter.ofPattern(retFormat));
    } catch (DateTimeParseException ex) {
        System.err.println("impossible to parse to yyyy_dd_MM");
    }

    return null;

}