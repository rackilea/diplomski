/**
* Zone to use for input and output
*/
private static final DateTimeZone ZONE = DateTimeZone.forId("Europe/London");

/**
 * Adds a number of days specified to the instant in time specified.
 *
 * @param instant - the date to be added to
 * @param numberOfDaysToAdd - the number of days to be added to the instant specified
 * @return an instant that has been incremented by the number of days specified
 */
public static Instant addNumberOfDaysToInstant(final Instant instant, final int numberOfDaysToAdd) {
    return instant.toDateTime(ZONE).withFieldAdded(DurationFieldType.days(), numberOfDaysToAdd).toInstant();
}