public class AppPrefrences {

            private static SharedPreferences mPrefs;
            private static SharedPreferences.Editor mPrefsEditor;

            public static boolean isButtonCLicked(Context ctx) {
                mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
                return mPrefs.getBoolean("button_clicked", true);
            }

            public static void setButtonCLicked(Context ctx, Boolean value) {
                mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
                mPrefsEditor = mPrefs.edit();
                mPrefsEditor.putBoolean("button_clicked", value);
                mPrefsEditor.commit();
            }

        }