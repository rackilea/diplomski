private static String getDayName(Context context, long dateInMillis) {
    ZoneId zone = ZoneId.systemDefault();
    LocalDate providedDate = Instant.ofEpochMilli(dateInMillis)
            .atZone(zone)
            .toLocalDate();
    LocalDate today = LocalDate.now(zone);

    int daysAfterToday = (int) ChronoUnit.DAYS.between(today, providedDate);

    switch (daysAfterToday) {
        case 0:
            return context.getString(R.string.today);
        case 1:
            return context.getString(R.string.tomorrow );

        default:
            return providedDate.getDayOfWeek()
                        .getDisplayName(TextStyle.FULL, 
                                        Locale.getDefault(Locale.Category.FORMAT));
    }
}