private static final Pattern PATTERN = Pattern.compile(", $");

public static String getFormattedDateDifference(final DateTime startDate,
    final DateTime endDate)
{
    // This variable will ultimately contain the number of days
    long days = endDate.getMillis() - startDate.getMillis();

    final long hours, minutes;

    days /= 60000; // Forget seconds and milliseconds

    minutes = days % 60;  days /= 60;

    hours = days % 24; days /= 24;

    final StringBuilder sb = new StringBuilder();

    if (days != 0) {
        sb.append(days).append(" day");
        if (days > 1)
            sb.append('s');
        sb.append(", ");
    }
    if (hours != 0) {
        sb.append(hours).append(" hour");
        if (hours > 1)
            sb.append('s');
        sb.append(", ");
    }
    if (minutes != 0) {
        sb.append(minutes).append(" minute");
        if (minutes > 1)
            sb.append('s');
        sb.append(", ");
    }

    return PATTERN.matcher(sb.toString()).replaceFirst("");
}