public class PrefUtilities {

private SharedPreferences preferences;
Context context;


private PrefUtilities(Context context) {
    preferences = PreferenceManager.getDefaultSharedPreferences(context);
    this.context = context;
}


public static PrefUtilities with(Context context){
    return new PrefUtilities(context);
}


public void setUserLogin(boolean isUserLogedin){

    preferences.edit().putBoolean(context.getString(R.string.pref_key_user_status),isUserLogedin).apply();

}

public boolean isUserLogedin(){
    return preferences.getBoolean(context.getString(R.string.pref_key_user_status),false);
}


}