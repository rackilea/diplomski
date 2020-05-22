public class AppPreferences {
        private SharedPreferences sPreferences;
        public static void init(Context context) {
            sPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        }

        public static SharedPreferences getPrefs() {
            return sPreferences;
        }
    }