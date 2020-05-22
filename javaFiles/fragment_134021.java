public class NrfMonthWeek {

    public static NrfMonthWeek getWeek(LocalDate date) {
        // Determine NRF calendar year.
        // The year begins on the Sunday in the interval Jan 29 through Feb 4.
        LocalDate firstDayOfNrfYear = date.with(MonthDay.of(Month.JANUARY, 29))
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        if (date.isBefore(firstDayOfNrfYear)) { // previous NRF year
            firstDayOfNrfYear = date.minusYears(1)
                    .with(MonthDay.of(Month.JANUARY, 29))
                    .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        }
        // 1-based week of NRF year
        int weekOfNrfYear = (int) ChronoUnit.WEEKS.between(firstDayOfNrfYear, date) + 1;
        assert 1 <= weekOfNrfYear && weekOfNrfYear <= 53 : weekOfNrfYear;
        YearMonth firstMonthOfNrfYear = YearMonth.from(firstDayOfNrfYear)
                .with(Month.FEBRUARY);
        if (weekOfNrfYear == 53) {
            // Special case: the last week of a 53 weeks year belongs to
            // the last month, January; this makes it a 5 weeks month.
            return new NrfMonthWeek(firstMonthOfNrfYear.plusMonths(11), 5);
        } else {
            // 1-based month of NRF year (1 = February through 12 = January).
            // A little math trickery to make the 4-5-4 pattern real.
            int monthOfNrfYear = (weekOfNrfYear * 3 + 11) / 13;
            // Number of weeks before the NRF month: 0 for February, 4 for March, 9 for April, etc.
            int weeksBeforeMonth = (monthOfNrfYear * 13 - 12) / 3;
            int weekOfMonth = weekOfNrfYear - weeksBeforeMonth;
            return new NrfMonthWeek(
                    firstMonthOfNrfYear.plusMonths(monthOfNrfYear - 1), weekOfMonth);
        }
    }

    private YearMonth month;
    /** 1 through 5 */
    private int weekOfMonth;

    public NrfMonthWeek(YearMonth month, int weekOfMonth) {
        this.month = Objects.requireNonNull(month);
        if (weekOfMonth < 1 || weekOfMonth > 5) {
            throw new IllegalArgumentException("Incorrect week number " + weekOfMonth);
        }
        this.weekOfMonth = weekOfMonth;
    }

    @Override
    public String toString() {
        return month.getMonth().getDisplayName(TextStyle.FULL, Locale.US)
                + " Week " + weekOfMonth;
    }
}