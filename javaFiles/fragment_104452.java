public static String toUpperCase(Locale locale, String s, int count) {
    String languageCode = locale.getLanguage();
    if (languageCode.equals("tr") || languageCode.equals("az") || languageCode.equals("lt")) {
        return ICU.toUpperCase(s, locale);
    }
    if (languageCode.equals("el")) {
        return EL_UPPER.get().transliterate(s);
    }

    ...
}