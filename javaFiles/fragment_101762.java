Preference myPref = (Preference) findPreference("myKey");
myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
             public boolean onPreferenceClick(Preference preference) {
                 //open browser or intent here
                 return true;
             }
         });