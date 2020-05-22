String ringtonePreference;
// Get the xml/preferences.xml preferences
                SharedPreferences prefs = PreferenceManager
                                .getDefaultSharedPreferences(getBaseContext());
 ringtonePreference = prefs.getString("ringtonePref",
                                "DEFAULT_RINGTONE_URI");