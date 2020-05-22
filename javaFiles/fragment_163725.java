// This method is now more testable.  Note this is only safe for non-DST zones
public static Calendar getCurrentTimeOnly() {

    Calendar cal = new Calendar();

    // DateTimeUtils is part of JodaTime, and is a class allowing you to pause time!
    cal.setTimeInMillis(DateTimeUtils.currentTimeMillis() % (24 * 60 * 60 * 1000));

    return cal;
}