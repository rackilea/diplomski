public interface Observer {
    void onSettingsChanged(String key, String value);
}

private static Observer observer;
public static void setObserver(Observer observer_) {
    observer = observer_;
}

public static void Save(SETTING_KEY key, String value) {
    SharedPreferences sp = _context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();

    editor.putString(key.toString(), value);
    editor.commit();
    if (observer != null) {
        observer.onSettingsChanged(key, value);
    }
}