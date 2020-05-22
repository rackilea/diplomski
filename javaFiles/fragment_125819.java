public LocalDate toLocalDate(YearMonth yearMonth) {
    // Get a temporal adjuster to adjust a LocalDate to match a day-of-the-week
    TemporalAdjuster adjuster = this.backwards ? TemporalAdjusters.lastInMonth(this.dayOfWeek) : TemporalAdjusters.firstInMonth(this.dayOfWeek);

    int weeks = this.position - 1;
    LocalDate date = yearMonth.atDay(1)
            .with(adjuster)
            .plusWeeks(this.backwards ? 0 - weeks : weeks);
    if (!Objects.equals(yearMonth, YearMonth.from(date))) {
        throw new DateTimeException(String.format("%s #%s in %s does not exist", this.dayOfWeek, this.position, yearMonth));
    }
    return date;
}