public class AppUtils {

private final static String SHARED_PREFS="AppUtils";
private SharedPreferences prefs;
private SharedPreferences.Editor edit;

public AppUtils(Context context) {
    prefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
}

public void setUserName(String name) {

    edit = prefs.edit();
    edit.putString("name", name);
    edit.commit();
}

public String getUserName() {
    return prefs.getString("name", "");
}