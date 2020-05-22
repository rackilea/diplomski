listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
 public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
   public void onSharedPreferenceChanged(
        SharedPreferences prefs, String key) {

        System.out.println(key);
 }
};
settings.registerOnSharedPreferenceChangeListener(listener);