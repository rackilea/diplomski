public class TestHarnes {

    public static String removeHashedSettings(final String key, final String a_settings, final String deilimiter) throws Exception {
        if (!(key != null && key.trim().length() > 0)) {
            return a_settings;
        }
        if (!(a_settings != null && a_settings.trim().length() > 0)) {
            return a_settings;
        }

        HashMap hSettings = CollectionUtil.createHashMap(a_settings, deilimiter);
        hSettings.remove(key);
        return getSettingFromHash(hSettings, deilimiter);
    }

    private static String getSettingFromHash(final HashMap hSettings, final String deilimiter) {
        return "";
    }

}