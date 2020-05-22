SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    String userTheme = prefs.getString("theme", "1");
    if (userTheme.equals("1"))
        setTheme(R.style.ThemeDark);
    else if (userTheme.equals("2"))
        setTheme(R.style.ThemeLight);