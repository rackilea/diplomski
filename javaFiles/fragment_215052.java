public static Map<Currency, Locale> getCurrencyLocaleMap() {
        Map<Currency, Locale> currencyLocaleMap = new HashMap<Currency, Locale>();
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                currencyLocaleMap.put(currency, locale);
            } catch (Exception e) {
            }
        }
        return currencyLocaleMap;
    }

    public static String getCurrencySymbol(String currencyCode) {
        String currencySymbol = null;
        if (currencyCode == null || currencyCode.isEmpty()) {
            currencySymbol = currencyCode;
        } else {
            Locale currencyLocale = null;
            Map<Currency, Locale> currencyLocaleMap = null;
            Currency currency = null;
            try {
                currency = Currency.getInstance(currencyCode);
                currencyLocaleMap = getCurrencyLocaleMap();
                currencyLocale = currencyLocaleMap.get(currency);
            } catch (Exception e) {
                System.out.println("No symbol is there for currencyCode="
                        + currencyCode);
            }
            if (currency != null && currencyLocale != null) {
                currencySymbol = currency.getSymbol(currencyLocaleMap
                        .get(currency));
            } else {
                currencySymbol = currencyCode;
            }
        }
        return currencySymbol;
    }
}