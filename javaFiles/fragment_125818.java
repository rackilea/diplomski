public static WeekdayInMonth of(LocalDate date) {
    int positionInMonth = (date.getDayOfMonth() - 1) / 7 + 1;
    return new WeekdayInMonth(date.getDayOfWeek(), positionInMonth, false);
}

private static WeekdayInMonth ofReversing(LocalDate date) {
    int lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    int positionInMonth = (lastDayOfMonth - date.getDayOfMonth()) / 7 + 1;
    return new WeekdayInMonth(date.getDayOfWeek(), positionInMonth, true);
}