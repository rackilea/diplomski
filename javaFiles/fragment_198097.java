for (FormatStyle fs : FormatStyle.values()) {
    for (Locale locale : Locale.getAvailableLocales()) {
        // get pattern for locale and style
        String pattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(fs, fs, IsoChronology.INSTANCE, locale);
    }
}