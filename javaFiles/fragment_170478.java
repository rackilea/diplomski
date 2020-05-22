public static String formatISODateTime(String isoString, String format) {

    ZonedDateTime date = null;
    String returnDate = null;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    try {
        date = ZonedDateTime.parse(isoString, dateTimeFormatter).withZoneSameInstant(ZoneOffset.UTC);
        returnDate = date.format(DateTimeFormatter.ofPattern(format));
    } catch(DateTimeParseException e) {
        // do something
    } catch(DateTimeException e) {
        // do something
    }

    return returnDate;
}