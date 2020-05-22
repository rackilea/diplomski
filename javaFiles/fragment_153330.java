SharedPreferences app_preferences = 
        PreferenceManager.getDefaultSharedPreferences(this);

 SharedPreferences.Editor editor = app_preferences.edit();
 editor.putString("item", item);
 editor.commit(); //Very important part