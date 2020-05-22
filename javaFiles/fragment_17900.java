public class WeakResourceBundle extends ResourceBundle {
    private Map cache = new WeakHashMap();
    protected Locale locale = Locale.US; // default fall-back locale

    // required - Base is abstract
    // @Override
    protected Object handleGetObject(String key) {
        if (cache.containsKey(key))
            return cache.get(key);

        String value = loadFromDatabase(key, locale);
        cache.put(key, value);

        return value;
    }

    // required - Base is abstract
    // @Override
    public Enumeration getKeys() {
        return loadKeysFromDatabase();
    }

    // optional but I believe needed
    // @Override
    public Locale getLocale() {
        return locale;
    }

    // dummy testing method, you need to provide your own
    // should throw MissingResourceException if key does not exist
    private String loadFromDatabase(String key, Locale aLocale) {
        System.out.println("Loading key: " + key
                + " from database for locale:"
                + aLocale );

        return "dummy_" + aLocale.getDisplayLanguage(aLocale);
    }

    // dummy testing method, you need to provide your own
    private Enumeration loadKeysFromDatabase() {
        return Collections.enumeration(new ArrayList());
    }
}