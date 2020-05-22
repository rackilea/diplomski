PreferenceManager.getDefaultSharedPreferences(this)
        .registerOnSharedPreferenceChangeListener(
            new OnSharedPreferenceChangeListener() {

        public void onSharedPreferenceChanged(
                SharedPreferences sharedPreferences, String key) {
            if (MYKEY1.equals(key) 
                    || MYKEY2.equals(key)) {
                 doSomething();
            }
        }
    });