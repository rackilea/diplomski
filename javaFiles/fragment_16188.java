private static LocalDate rollWeekOfMonth(LocalDate date, int amount, WeekFields wf) {
    LocalDate firstOfMonth = date.withDayOfMonth(1);
    int firstWeekOfMonth = firstOfMonth.get(wf.weekOfMonth());
    LocalDate lastOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
    int lastWeekOfMonth = lastOfMonth.get(wf.weekOfMonth());
    int weekCount = lastWeekOfMonth - firstWeekOfMonth + 1;
    int newWeekOfMonth = firstWeekOfMonth
            + (date.get(wf.weekOfMonth()) - firstWeekOfMonth
                            + amount % weekCount + weekCount)
                    % weekCount;
    LocalDate result = date.with(wf.weekOfMonth(), newWeekOfMonth);
    if (result.isBefore(firstOfMonth)) {
        result = firstOfMonth;
    } else if (result.isAfter(lastOfMonth)) {
        result = lastOfMonth;
    }
    return result;
}