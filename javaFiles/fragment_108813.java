@Override
public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
    super.onPreferenceTreeClick(preferenceScreen, preference);

    // If the user has clicked on a preference screen, set up the action bar
    if (preference instanceof PreferenceScreen) {
        initializeActionBar((PreferenceScreen) preference);
    }

    return false;
}