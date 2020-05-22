@Override
    protected void onCreate() {
        super.onCreate()
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        isDark = preferences.getBoolean("theme", false);
    }

@Override
    protected void onResume() {
        super.onResume();
        if(isDark != preferences.getBoolean("theme", false))
            recreate();
    }