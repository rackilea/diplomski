public int loadTheme(){
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    //Load theme color
    int theme = sharedPreferences.getInt("Theme",Color.RED); //RED is default color, when nothing is saved yet

    return theme;
}