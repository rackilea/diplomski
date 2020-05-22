SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
SharedPreferences.Editor editor = settings.edit();
editor.putString("oauthKey", yourOAuthKey);

// Commit the edits!
editor.commit();