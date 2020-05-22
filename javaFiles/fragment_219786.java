if (key.equals("url")) {
        String value = sharedPreferences.getString(key, "");

        if (value.endsWith("/")) {
            EditTextPreference editTextPreference = (EditTextPreference)findPreference(key);
            editTextPreference.setText(value.substring(0, value.length() - 1));
        }
    }