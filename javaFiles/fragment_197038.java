public class Backgroundoznameni extends Service {
    public static final String PREFS_NAME = "NativeStorage";
      @Override
      public void onCreate() {
        String value = getValue(Backgroundoznameni.this, "somekey", null);
      }

      String getValue(Context context, String key, String defaultValue) {
            SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
            return settings.getString(key, defaultValue);
        }
    }