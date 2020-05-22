final SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
    // update your listview.
  }
};

prefs.registerOnSharedPreferenceChangeListener(listener);