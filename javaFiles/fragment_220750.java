Locale locale; // set to locale of your choice, i.e. "fa"
  Configuration config = getResources().getConfiguration();
  config.setLocale(locale); // There's an setter, don't set it directly     
  getApplicationContext().getResources().updateConfiguration(
      config,
      getApplicationContext().getResources().getDisplayMetrics()
  );
  // you might even need to use getApplicationContext().getBaseContext(), here.
  Locale.setLocale(locale);