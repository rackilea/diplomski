private static final Calendar START_CAL = createAugust26th2012Cal();

public int getWeekNumber(Calendar someCal) {
    int theWeek = someCal.get(Calendar.WEEK_OF_YEAR);
    int weekCount = 0;
    while (theWeek != START_CAL.get(Calendar.WEEK_OF_YEAR)) {
        someCal.add(Calendar.WEEK_OF_YEAR, -1);
        theWeek = someCal.get(Calendar.WEEK_OF_YEAR);
        weekCount++;
    }
    return weekCount;
}