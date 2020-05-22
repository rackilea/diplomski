private static final long ONE_WEEK_MILLIS = 1000 * 60 * 60 * 24 * 7;

public int getWeeksBetween(Calendar calOne, Calendar calTwo) {
    long millisOne = calOne.getTime().getTime();
    long millisTwo = calTwo.getTime().getTime();
    long offsetOne = calOne.getTimeZone().getOffset(millisOne);
    long offsetTwo = calTwo.getTimeZone().getOffset(millisTwo);
    long diff = (millisTwo - offsetTwo) - (millisOne + offsetOne );
    return diff / ONE_WEEK_MILLIS;
}