private static final PeriodType PERIOD_TO_MINUTES = 
     PeriodType.standard().withSecondsRemoved().withMillisRemoved();

public static String getFormattedDateDifference(DateTime startDate,
                                                DateTime endDate) {

    Period p = new Period(startDate, endDate, PERIOD_TO_MINUTES);
    return PeriodFormat.getDefault().print(p);
}