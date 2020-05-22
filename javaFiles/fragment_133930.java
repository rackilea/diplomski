SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

//Creating editor to store values to shared preferences
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.clear();

//Adding values to editor
editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true)
      .putString(Config.PHONE_SHARED_PREF, phoneNo)
      .commit(); // returns true if successfully saved. 

Log.d("debug", "config " + sharedPreferences.getString(Config.PHONE_SHARED_PREF, "");