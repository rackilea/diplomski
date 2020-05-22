/**
 * Generate a CRON expression is a string comprising 6 or 7 fields separated by white space.
 *
 * @param seconds    mandatory = yes. allowed values = {@code  0-59    * / , -}
 * @param minutes    mandatory = yes. allowed values = {@code  0-59    * / , -}
 * @param hours      mandatory = yes. allowed values = {@code 0-23   * / , -}
 * @param dayOfMonth mandatory = yes. allowed values = {@code 1-31  * / , - ? L W}
 * @param month      mandatory = yes. allowed values = {@code 1-12 or JAN-DEC    * / , -}
 * @param dayOfWeek  mandatory = yes. allowed values = {@code 0-6 or SUN-SAT * / , - ? L #}
 * @param year       mandatory = no. allowed values = {@code 1970–2099    * / , -}
 * @return a CRON Formatted String.
 */
private static String generateCronExpression(final String seconds, final String minutes, final String hours,
                                             final String dayOfMonth,
                                             final String month, final String dayOfWeek, final String year)
{
  return String.format("%1$s %2$s %3$s %4$s %5$s %6$s %7$s", seconds, minutes, hours, dayOfMonth, month, dayOfWeek, year);
}