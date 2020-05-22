public class PreferenceData 
{
    static final String PREF_USER_ID = "user_logged_in";

    public static SharedPreferences getSharedPreferences(Context ctx) 
    {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserLoggedIn(Context ctx, boolean userLoggedIn) 
    {
        Editor editor = getSharedPreferences(ctx).edit();
        editor.putBoolean(PREF_USER_ID, userLoggedIn);
        editor.commit();
    }

    public static boolean getUserLoggedIn(Context ctx) 
    {
        return getSharedPreferences(ctx).putBoolean(PREF_USER_ID, false);
    }
}