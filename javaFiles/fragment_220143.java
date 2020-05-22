public class AppPreference {


    public static final String PREF_USERID = "prefUserId";
    public static final String PREF_FNAME = "prefFname";
    public static final String PREF_LNAME = "prefLname";
    public static final String PREF_PHONE = "prefphone";


    public static final void setStringPref(Context context, String prefKey, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(prefKey, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static final String getStringPref(Context context, String prefName, String key) {
        SharedPreferences sp = context.getSharedPreferences(prefName, 0);
        return sp.getString(key, "");
    }

    public static final class PREF_KEY {
        public static final String USERID = "userid";
        public static final String FNAME = "fname";
        public static final String LNAME = "lname";
        public static final String PHONE = "phone";
    }
}