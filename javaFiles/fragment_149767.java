public SimpleDateFormat(String pattern, Locale locale)
{
    if (pattern == null || locale == null) {
        throw new NullPointerException();
    }

    initializeCalendar(locale);
    this.pattern = pattern; // This part is important
    this.formatData = DateFormatSymbols.getInstanceRef(locale);
    this.locale = locale;
    initialize(locale);
}