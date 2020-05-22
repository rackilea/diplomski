public void saveTheme(int theme)
{
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    prefEditor.putInt("Theme",theme); 
}