Intent intent = new Intent(this, SettingsActivity.class);
startActivity(intent);
Log.w("back from intent", "\n");
//preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
preferences = PreferenceManager.getDefaultSharedPreferences(this);
focusAtClue = preferences.getBoolean("focus",true);
screenSaver = preferences.getBoolean("screen",true);
Log.w("after intent", focusAtClue + " " + screenSaver);
return true;