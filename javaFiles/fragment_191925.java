public DateFormatSymbols(Locale locale) {
    this.locale = locale;
    this.localPatternChars = SimpleDateFormat.PATTERN_CHARS;
    LocaleData localeData = LocaleData.get(locale);
    this.ampms = localeData.amPm;
    this.eras = localeData.eras;
    this.months = localeData.longMonthNames;
    this.shortMonths = localeData.shortMonthNames;
    this.weekdays = localeData.longWeekdayNames;
    this.shortWeekdays = localeData.shortWeekdayNames;

    // ICU/Android extensions.
    this.longStandAloneMonths = localeData.longStandAloneMonthNames;
    this.shortStandAloneMonths = localeData.shortStandAloneMonthNames;
    this.longStandAloneWeekdays = localeData.longStandAloneWeekdayNames;
    this.shortStandAloneWeekdays = localeData.shortStandAloneWeekdayNames;
}