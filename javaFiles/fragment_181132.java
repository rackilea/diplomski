//For storing string value in sharedPreference     
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString("Name","Harneet");
    editor.commit();

    //For retrieving string value from sharedPreference
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    String name = preferences.getString("Name","");