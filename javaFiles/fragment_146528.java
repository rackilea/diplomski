// get ahold of the SwitchPreference instance
SwitchPreference pref = (SwitchPreference) findPreference("industrial_tax");

// if it's not checked, then remove the corresponding Preference
if (!pref.isChecked()) {
    Log.v(TAG, "If-Schleife");

    Preference residence = findPreference("residence");
    getPreferenceScreen().removePreference(residence);
}