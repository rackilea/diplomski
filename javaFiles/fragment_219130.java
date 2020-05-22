public class SharedPreferenceManager {
    private static final String PREFS_NAME = Config.SHARED_PREF_NAME;

    /**
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveToPreference(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }


    /**
     * @param context
     * @param key
     * @return
     */
    public static String loadFromPreference(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }
}