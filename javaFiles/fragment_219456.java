public class project_constants {
private static String PREF_NAME = "project_pref";

private static SharedPreferences getPrefs(Context context) {
    return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
}

public static boolean getUserLogin(Context context) {
    return getPrefs(context).getBoolean("login", false);
}

public static void setUserLogin(Context context, boolean input) {
    SharedPreferences.Editor editor = getPrefs(context).edit();
    editor.putBoolean("login", input);
    editor.apply();
}