public class AppPreference {
    private static final String FILE_NAME = BuildConfig.APPLICATION_ID + ".apppreference";
    private static final String APP_GENERAL_SETTINGS = "app_general_settings";
    private final SharedPreferences preferences;

    public AppPreference(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    }

    public SharedPreferences.Editor setGeneralSettings(AppGeneralSettings appGeneralSettings) {
        return preferences.edit().putString(APP_GENERAL_SETTINGS, new Gson().toJson(appGeneralSettings));
    }

    public AppGeneralSettings getGeneralSettings() {
        return new Gson().fromJson(preferences.getString(APP_GENERAL_SETTINGS, "{}"), AppGeneralSettings.class);
    }
}