public class myprefs extends Activity{
private static final String PREFS_XML = "prefs_xml";
private static final String PREF_1 = "pref_1";

String preference;

private SharedPreferences preferences = null;
public void loadPrefs(){
    preferences = this.getSharedPreferences(PREFS_XML, Activity.MODE_PRIVATE);
    preference = preferences.getString(PREF_1, "default value");
}
}