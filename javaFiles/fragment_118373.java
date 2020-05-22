public static Locale getDefault() {
    // do not synchronize this method - see 4071298
    // it's OK if more than one default locale happens to be created
    if (defaultLocale == null) {
        String language, region, country, variant;
        language = AccessController.doPrivileged(
            new GetPropertyAction("user.language", "en"));
        // for compatibility, check for old user.region property
        region = AccessController.doPrivileged(
            new GetPropertyAction("user.region"));
        if (region != null) {
            // region can be of form country, country_variant, or _variant
            int i = region.indexOf('_');
            if (i >= 0) {
                country = region.substring(0, i);
                variant = region.substring(i + 1);
            } else {
                country = region;
                variant = "";
            }
        } else {
            country = AccessController.doPrivileged(
                new GetPropertyAction("user.country", ""));
            variant = AccessController.doPrivileged(
                new GetPropertyAction("user.variant", ""));
        }
        defaultLocale = getInstance(language, country, variant);
    }
    return defaultLocale;
}