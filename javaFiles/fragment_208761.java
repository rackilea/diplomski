/**
 * Reset Joda DateTime by normalize it back to the beginning of the period
 */
static DateTime resetDate(BaseSingleFieldPeriod period,
                                DateTime date) {
    LocalDate out = new LocalDate(date)
    switch (period) {
        case Years.ONE:
            out = out.withMonthOfYear(1).withDayOfMonth(1)
            break;
        case Months.ONE:
            out = out.withDayOfMonth(1)
            break;
        case Weeks.ONE:
            // adjust day of week because Joda uses ISO standard Monday
            // as start of the week
            out = out.withDayOfWeek(1).minusDays(1)
            break;
        case Days.ONE:
            // nothing to for days as we have already removed time by
            // converting to local date
            break;
        default:
            throw new UnsupportedOperationException("Unsupported period $period")
    }

    // convert to date minute to avoid giving specific time
    out.toDateMidnight().toDateTime()
}