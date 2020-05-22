public static String timeUntil(int hourOfDay, int minuteOfHour) {
    Period period = Period.fieldDifference(LocalTime.now(DateTimeZone.UTC),
                                           new LocalTime(hourOfDay, minuteOfHour))
                          .plusHours(24).normalizedStandard().withDays(0).withMillis(0);
    StringBuffer buf = new StringBuffer();
    PeriodFormat.wordBased(Locale.US).printTo(buf, period);
    return buf.toString();
}