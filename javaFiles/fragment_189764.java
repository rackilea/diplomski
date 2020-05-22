@Override
public void onCreate() {
    super.onCreate();
    Fabric.with(this, new Crashlytics());
    PreferenceManager mPreferenceManager = new PreferenceManager(getApplicationContext());

    mLang = mPreferenceManager.getLocale();  // Here I have got incorrect value

    if (mLang.equals("default")) mLang = getResources().getConfiguration().locale.getLanguage();

    Log.d(TAG, "onCreate: lang = " + mLang);

    mLocale = new Locale(mLang);
    Locale.setDefault(mLocale);
    Configuration config = new Configuration();
    config.locale = mLocale;
    getBaseContext().getResources().updateConfiguration(config, null);
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mLocale = new Locale(mLang);
    Locale.setDefault(mLocale);
    Configuration config = new Configuration();
    config.locale = mLocale;
    getBaseContext().getResources().updateConfiguration(config, null);
}