prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // The seconde value of method getBoolean incates the default value if constant not found
        if (prefs.getBoolean(Constants.CALL_DONE, false)) {
            // Make call
            prefs.edit().putBoolean(Constants.CALL_DONE, true).apply();
        }