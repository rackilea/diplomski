Locale[] locales = { Locale.US, Locale.FRANCE, Locale.GERMANY,
            Locale.forLanguageTag("da-DK"), Locale.forLanguageTag("sr-BA") };
    LocalDate today = LocalDate.now(ZoneId.of("Europe/Sarajevo"));
    for (Locale currentLocale : locales) {
        DateTimeFormatter ldf = getLocalizedDateFormatter(currentLocale);
        System.out.format(currentLocale, "%-33S%s%n", 
                currentLocale.getDisplayName(), today.format(ldf));
    }