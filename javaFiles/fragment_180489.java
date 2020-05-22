private static final String[] dateFormats
        = "yyyyMMdd,yyyy/MM/dd,yyyy-MM-dd,dd/MM/yyyy,dd-MM-yyyy,dd-MMM-yyyy,yyyy MM dd"
                .split(",");

public static LocalDate parseAllDateFormats(String date) {
    if (date == null) {
        return null;
    }
    for (String format : dateFormats) {
        try {
            System.out.println("trying " + format);                
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            return LocalDate.parse(date, dateFormatter);
        }
        catch (DateTimeParseException e) {
            // Ignore, try next format
        }
    }
    return null;
}