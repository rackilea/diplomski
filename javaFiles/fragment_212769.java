public boolean hasPassedAYear(Date date) {
    DateTime currentDate = new DateTime();
    DateTime dateToEval = new DateTime(date);
    Interval interval = new Interval(dateToEval, currentDate);
    return interval.toPeriod().getYears() >= 1;
}