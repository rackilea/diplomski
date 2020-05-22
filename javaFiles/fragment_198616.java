static TimeZone getDefaultRef() {
    TimeZone defaultZone = getDefaultInAppContext();
    if (defaultZone == null) {
        defaultZone = defaultTimeZone;
        if (defaultZone == null) {
            // Need to initialize the default time zone.
            defaultZone = setDefaultZone();
            assert defaultZone != null;
        }
    }
    // Don't clone here.
    return defaultZone;
}