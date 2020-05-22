private static final String DATE_PATTERN = "MM/yy";

public int getLastDayOfMonth(String dateString) {
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern(DATE_PATTERN);
    YearMonth yearMonth = YearMonth.parse(dateString, pattern);
    LocalDate date = yearMonth.atEndOfMonth();
    return date.lengthOfMonth();
}