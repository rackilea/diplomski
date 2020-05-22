SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            Editor edit = pref.edit();
            edit.putString(key, value);
            edit.commit();

            //Any activity
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            pref.getString(key, defValue);