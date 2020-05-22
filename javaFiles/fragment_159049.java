String method = "multiplication";

// We need an Editor object to make preference changes.
SharedPreferences settings = getSharedPreferences("mySettings", Activity.MODE_PRIVATE);
SharedPreferences.Editor editor = settings.edit();
editor.putBoolean("method", method);

// Commit the edits!
editor.commit();