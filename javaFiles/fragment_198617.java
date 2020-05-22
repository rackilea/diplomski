public static Locale getDefault(Locale.Category category) {
    // do not synchronize this method - see 4071298
    // it's OK if more than one default locale happens to be created
    switch (category) {
    case DISPLAY:
        if (defaultDisplayLocale == null) {
            initDefault(category);
        }
        return defaultDisplayLocale;
    case FORMAT:
        if (defaultFormatLocale == null) {
            initDefault(category);
        }
        return defaultFormatLocale;
    default:
        assert false: "Unknown Category";
    }
    return getDefault();
}