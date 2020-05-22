public void handleTEST(){
    final EditTextPreference pref = (EditTextPreference) findPreference("test");
    pref.setTitle(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("test", "Default Title"));
    // Loads the title for the first time
    // Listens for change in value, and then changes the title if required.
    pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            pref.setText(newValue.toString());
            return false;
        }
    });
}