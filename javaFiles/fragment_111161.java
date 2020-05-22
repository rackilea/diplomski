private String getDifference(DateTime from, DateTime to, boolean showMilliseconds) {
    Period period;

    if (from.isAfter(to)) {
        period = new Period(to, from);
    } else {
        period = new Period(from, to);
    }

    PeriodFormatterBuilder builder = new PeriodFormatterBuilder()
        .appendYears()
        .appendSuffix(" year, ", " years, ")
        .appendMonths()
        .appendSuffix(" month, ", " months, ")
        .appendWeeks()
        .appendSuffix(" week, ", " weeks, ")
        .appendDays()
        .appendSuffix(" day, ", " days, ")
        .appendHours()
        .appendSuffix(" hour, ", " hours, ")
        .appendMinutes()
        .appendSuffix(" minute, ", " minutes, ")
        .appendSeconds()
        .appendSuffix(" second, ", " seconds, ");

    if (showMilliseconds) {
        builder = builder.appendMillis().appendSuffix(" millisecond", " milliseconds");
    }

    return builder
        .toFormatter()
        .print(period)
        .replaceAll("[,]\\s*$", "")
        .replaceAll("(?:,\\s*)([^,]+)$", " and $1")
        .replaceAll("^(?![\\s\\S])", "No difference");
}