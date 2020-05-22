Locale[] availableLocales = Locale.getAvailableLocales();
    for (Locale locale : availableLocales) {
        if ("en".equals(locale.getLanguage())) {
            System.out.println(locale);
        }
    }