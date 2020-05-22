// Tests if the end date is within so many days of the start date 
public static boolean isWithinRange(int days,  Date end, Date start) {
    return TimeUnit.DAYS.convert(end.getTime() - start.getTime(), TimeUnit.MILLISECONDS) < days;
}

// Tests if the specified date is within so many days of today 
public static boolean isWithinRange(int days, Date end) {
    return isWithinRange(days, end, new Date());
}