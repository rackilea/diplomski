public static <T> void saveLocalData(Context context, String key, T value) {
    SharedPreferences prefs = context.getSharedPreferences(
        Constants.PREFERENCES_KEY, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    if (value instanceof String) { 
        editor.putString(key, (String) value);
    }
    else if (value instanceof Boolean){
        editor.putBoolean(key, (Boolean) value);
    }
    editor.commit();
}