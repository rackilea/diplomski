Preference pref;
pref = frag.findPreference("pref_updates");

pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return true;
    }
});