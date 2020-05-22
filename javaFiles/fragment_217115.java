public long getNumberOfDayOfMonthBetweenDates(LocalDate startDate, LocalDate endDate, int dayOfMonth) {
    long result = -1;
    if (startDate != null && endDate != null && dayOfMonth > 0 && dayOfMonth < 32) {
        result = 0;
        LocalDate startDay = getDayInCurrentMonth(startDate, dayOfMonth);
        // add one day as end date is exclusive
        // add + 1 to cover higher possibilities (month and a half or half month or so)
        long totalMonths = ChronoUnit.MONTHS.between(startDate, endDate.plusDays(1)) + 2;
        for (int i = 0; i < totalMonths; i++) {
            if ((!startDay.isBefore(startDate) && startDay.isBefore(endDate)) || startDay.equals(startDate) || startDay.equals(endDate)) {
                result++;
            }
            startDay = getDayInCurrentMonth(startDay.plusMonths(1), dayOfMonth);
        }
    }
    return result;
}

private LocalDate getDayInCurrentMonth(LocalDate startDate, int dayOfMonth) {
    LocalDate dayOfThisMonth;
    try {
        dayOfThisMonth = startDate.withDayOfMonth(dayOfMonth);
    } catch (DateTimeException e) {
        // handle cases where current month does not contain the given day (example 30 in Feb)
        dayOfThisMonth = startDate.withDayOfMonth(startDate.lengthOfMonth());
    }
    return dayOfThisMonth;
}