SharedPreferences settings = getSharedPreferences(Example.PREFS_NAME, 0); // 0 - for private mode
    SharedPreferences.Editor editor = settings.edit();

    //Set "hasLoggedIn" to true
    editor.putBoolean("hasLoggedIn", true);

    // Commit the edits!
    editor.commit();