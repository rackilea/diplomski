SharedPreferences pref = getSharedPreferences(LOGIN_PREFS_NAME, Context.MODE_PRIVATE);
        if (pref.getBoolean(KEY_FIRST_TIME_ON_APP, false)) {

           //in here it's not for first time

        } else {

             //in here it's first time
        }