Locale locale = new Locale("hi"); // where 'hi' is Language code, set this as per your Spinner Item selected
Locale.setDefault(locale);
Configuration config = getBaseContext().getResources().getConfiguration();
config.locale = locale;
getBaseContext().getResources().updateConfiguration(config,
      getBaseContext().getResources().getDisplayMetrics());