//Get the custom preference
Preference refreshPref = (Preference) findPreference("refreshPref");
refreshPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
        public boolean onPreferenceClick(Preference preference) {
               PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("SHOULD_REFRESH", true).commit();             
               return true;
                      }

              });