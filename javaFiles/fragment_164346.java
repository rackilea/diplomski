private static Calendar createCalendar(TimeZone zone, Locale aLocale) {
    // If the specified locale is a Thai locale, returns a BuddhistCalendar
    // instance.
    if ("th".equals(aLocale.getLanguage())
        && ("TH".equals(aLocale.getCountry()))) {
        return new sun.util.BuddhistCalendar(zone, aLocale);
    } else if ("JP".equals(aLocale.getVariant())
        && "JP".equals(aLocale.getCountry())
        && "ja".equals(aLocale.getLanguage())) {
        return new JapaneseImperialCalendar(zone, aLocale);
    }       

    // else create the default calendar
    return new GregorianCalendar(zone, aLocale);    
}