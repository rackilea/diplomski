String getPattern(Locale locale) {
    DateFormat f = null;
    switch (iType) {
        case DATE:
            f = DateFormat.getDateInstance(iDateStyle, locale);
            break;
        case TIME:
            f = DateFormat.getTimeInstance(iTimeStyle, locale);
            break;
        case DATETIME:
            f = DateFormat.getDateTimeInstance(iDateStyle, iTimeStyle, locale);
            break;
    }
    if (f instanceof SimpleDateFormat == false) {
        throw new IllegalArgumentException("No datetime pattern for locale: " + locale);
    }
    return ((SimpleDateFormat) f).toPattern();
}