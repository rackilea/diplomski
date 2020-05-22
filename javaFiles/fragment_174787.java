Interval interval = new Interval(start, end);
int startMonth = 7; int endMonth = 8;
DateTime month1 = start
        .withMonthOfYear(startMonth)
        .withDayOfMonth(1);
DateTime month2 = start
        .withMonthOfYear(endMonth + 1)
        .withDayOfMonth(1)
        .minusDays(1);
if (month1.compareTo(month2) > 0)
    month2.plusYears(1);
Interval season = new Interval(month1, month2);
if (season.overlaps(window)) {
    return  window.overlap(season);
}