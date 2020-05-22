public class UserPreference {


SharedPreferences pref;

// Editor for Shared preferences
SharedPreferences.Editor editor;

// Context
Context _context;

// Shared pref mode
int PRIVATE_MODE = 0;

// Sharedpref file name
private static final String PREF_NAME = "user_preference";

public static final String isSportsCheck = "isSportsChecked";
public static final String isTechnologyCheck = "isTechnologyChecked";

 public UserPreference(Context context){
    this._context = context;
    pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    editor = pref.edit();
}

public void createWork(boolean sports, boolean tech){
    editor.putBoolean(isSportsCheck, sports);
    editor.putBoolean(isTechnologyCheck, tech);
    editor.commit();
}

public HashMap<String, String> getWorkDetails(){
    HashMap<String, String> user = new HashMap<String, String>();
    user.put(isSportsCheck, pref.getBoolean(isSportsCheck, false));
    user.put(isTechnologyCheck, pref.getBoolean(isTechnologyCheck, false));

    return user;
}