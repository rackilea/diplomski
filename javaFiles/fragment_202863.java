public static DateTimeFormatter getLocalizedDateFormatter(Locale requestedLocale) {
    String formatPatternString = DateTimeFormatterBuilder.getLocalizedDateTimePattern(
            FormatStyle.SHORT, null, 
            Chronology.ofLocale(requestedLocale), requestedLocale);
    // if not already showing month name, modify so it shows abbreviated month name
    if (! formatPatternString.contains("MMM")) {
        formatPatternString = formatPatternString.replaceAll("M+", "MMM");
    }
    return DateTimeFormatter.ofPattern(formatPatternString, requestedLocale);
}