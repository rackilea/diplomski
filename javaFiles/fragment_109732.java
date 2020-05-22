public static LocalDate resolveInvalidDate(String nextFieldTypeDate) {
    ParsePosition position = new ParsePosition(0);
    TemporalAccessor parsed = DateTimeFormatter.ISO_LOCAL_DATE
            .parseUnresolved(nextFieldTypeDate, position);
    if (position.getIndex() < nextFieldTypeDate.length()) {
        throw new IllegalArgumentException("Could not parse entire string");
    }
    YearMonth ym = YearMonth.from(parsed);
    int lastDayOfMonth = ym.lengthOfMonth();
    int parsedDayOfMOnth = parsed.get(ChronoField.DAY_OF_MONTH);
    if (parsedDayOfMOnth > lastDayOfMonth) { // invalid, must be adjusted to lasst day of month
        return ym.atEndOfMonth();
    } else {
        return ym.atDay(parsedDayOfMOnth);
    }
}