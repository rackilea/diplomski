public class AppPrefrences {

            private static SharedPreferences mPrefs;
            private static SharedPreferences.Editor mPrefsEditor;

    public static String getLastTime(Context ctx) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            return mPrefs.getString("lstTime", "");
        }

        public static void setLastTime(Context ctx, String value) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            mPrefsEditor = mPrefs.edit();
            mPrefsEditor.putString("lastTime", value);
            mPrefsEditor.commit();
        }

public static void clearAllData(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.clear();
        mPrefsEditor.commit();
    }
        }