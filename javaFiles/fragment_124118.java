DateTime since = ...;
DateTime now = ...;

Period period = new Period(since, now, PeriodType.yearMonthDay());
int years = period.getYears();
int months = period.getMonths();
int days = period.getDays();