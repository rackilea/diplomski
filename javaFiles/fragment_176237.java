private void saveStringToPreferences(String key, String str){
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
     SharedPreferences.Editor editor = preferences.edit();
     editor.putString(key, str);
     editor.apply();
}

private void getStringFromPreferences(String key){
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    String previousText = preferences.getString(key, "");
    return previousText;
}