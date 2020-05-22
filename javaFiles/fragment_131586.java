SharedPreferences prefs = PreferenceManager
 .getDefaultSharedPreferences(this.getApplicationContext());
 OnSharedPreferenceChangeListener listener;
 listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences arg0,
        String key) {

        if (key.equalsIgnoreCase("isRegistered")) {

            Log.v("RegistrationScreen", "registration status changed");             
            if (prefs.getBoolean("isRegistered", false))
                {
                  textView.setText("Registered Successfully");
                }
                else
                {
                  textView.setText("Successfully UnRegistered");
                }
        }
    }
};
    prefs.registerOnSharedPreferenceChangeListener(listener);