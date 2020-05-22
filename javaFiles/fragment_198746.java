checkBoxPreference = (CheckBoxPreference) this.findPreference("CheckBoxPref_KEY_HERE");

checkBoxPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
            // do your work here
            return true;
        }
    });