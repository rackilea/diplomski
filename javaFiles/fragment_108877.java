public int getValue(String key) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int value = sharedPref.getInt(key, 0);
        return value;
 }
 public void saveValue(String key, int value) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
 }