public static boolean isValid(String date, Instant start, Instant end) {
    LocalDate sld = start.atOffset(ZoneOffset.UTC).toLocalDate();
    LocalDate eld = end.atOffset(ZoneOffset.UTC).toLocalDate();
    try {
        LocalDate ld = LocalDate.parse(date);
        return ld.isAfter(sld) && ld.isBefore(eld);
    } catch (DateTimeParseException e) {}

    try {
        YearMonth ym = YearMonth.parse(date);
        return ym.isAfter(YearMonth.from(sld)) && ym.isBefore(YearMonth.from(eld));
    } catch (DateTimeParseException e) {}

    try {
        Year y = Year.parse(date);
        return y.isAfter(Year.from(sld)) && y.isBefore(Year.from(eld));
    } catch (DateTimeParseException e) {}
    return false;
}