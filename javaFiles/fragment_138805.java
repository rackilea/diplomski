public static boolean isDateOdd(String date) {
    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("MMM d yyyy")
            .toFormatter(Locale.ENGLISH);
    LocalDate outputDate = LocalDate.parse(date, formatter);
    return (outputDate.getDayOfYear() % 2 != 0);
}