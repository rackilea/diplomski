public static void setMobileFile(Context context, String value) {

    SharedPreferences preferences = context.getSharedPreferences(ABC_APP_SHARED_PREFERENCES, Context.MODE_PRIVATE);

    preferences.edit().putString(MOBILE_FILE, value).commit();
}


public static String getMobileFile(Context context) {

    SharedPreferences preferences = context.getSharedPreferences(ABC_APP_SHARED_PREFERENCES, Context.MODE_PRIVATE);

    return preferences.getString(MOBILE_FILE, "");
}