String language ="es";
    Locale locale = null;
    if (language.equalsIgnoreCase("en")) {
        locale = new Locale("en");
    } else if (language.equalsIgnoreCase("es")) {
        locale = new Locale("es");
    }
    Locale.setDefault(locale);
    Configuration config = new Configuration();
    config.locale = locale;
    getBaseContext().getResources().updateConfiguration(config, null);