public static String convertLongToDate(long timestamp) {
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MMM yyyy");
    ZonedDateTime today = ZonedDateTime.now(ZoneId.systemDefault());
    ZonedDateTime yesterday = today.minusDays(1);

    ZonedDateTime givenDate = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault());

    String timeString;
    // compare just the date (day, month, year)
    // no need to convert to string to compare if dates are the same
    if (today.toLocalDate().equals(givenDate.toLocalDate())) {
        timeString = AppConstants.TODAY;
    } else if (yesterday.toLocalDate().equals(givenDate.toLocalDate())) {
        timeString = AppConstants.YESTERDAY;
    } else {
        timeString = givenDate.format(f);
    }
    timeString = timeString.trim();
    return timeString;
}