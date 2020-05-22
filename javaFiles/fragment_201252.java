public class Pref_Storage {
    private static SharedPreferences sharedPreferences = null;

    public static void openPref(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.app_name),
                Context.MODE_PRIVATE);
    }

    public static void deleteKey(Context context, String key) {
        HashMap<String, String> result = new HashMap<String, String>();

        Pref_Storage.openPref(context);
        for (Entry<String, ?> entry : Pref_Storage.sharedPreferences.getAll()
                .entrySet()) {
            result.put(entry.getKey(), (String) entry.getValue());
        }

        boolean b = result.containsKey(key);
        if (b) {
            Pref_Storage.openPref(context);
            Editor prefsPrivateEditor = Pref_Storage.sharedPreferences.edit();
            prefsPrivateEditor.remove(key);

            prefsPrivateEditor.commit();
            prefsPrivateEditor = null;
            Pref_Storage.sharedPreferences = null;
        }
    }

    public static void setDetail(Context context, String key, String value) {
        Pref_Storage.openPref(context);
        Editor prefsPrivateEditor = Pref_Storage.sharedPreferences.edit();
        prefsPrivateEditor.putString(key, value);

        prefsPrivateEditor.commit();
        prefsPrivateEditor = null;
        Pref_Storage.sharedPreferences = null;
    }

    public static Boolean checkDetail(Context context, String key) {
        HashMap<String, String> result = new HashMap<String, String>();

        Pref_Storage.openPref(context);
        for (Entry<String, ?> entry : Pref_Storage.sharedPreferences.getAll()
                .entrySet()) {
            result.put(entry.getKey(), (String) entry.getValue());
        }

        boolean b = result.containsKey(key);
        return b;
    }
}