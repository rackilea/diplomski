Map<String,Locale> locales = new HashMap<String,Locale>();
    for (Locale l1: Locale.getAvailableLocales()) {
        for (Locale l2: Locale.getAvailableLocales()) {
            locales.put(l2.getDisplayName(l1), l2);
        }
    }