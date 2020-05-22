public static int weekDaysInMonth(LocalDate refDate) {
    LocalDate firstOfMonth = refDate.withDayOfMonth(1);
    LocalDate nextMonth = firstOfMonth.plusMonths(1);
    int days = 20;
    for (LocalDate date = firstOfMonth.plusDays(28); date.isBefore(nextMonth); date = date.plusDays(1))
        if (date.getDayOfWeek().getValue() <= 5) // 1=Mon - 5=Fri, i.e. not 6=Sat and 7=Sun
            days++;
    return days;
}