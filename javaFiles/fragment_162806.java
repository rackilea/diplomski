SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
SharedPreferences.Editor editor = settings.edit();

Calendar now = Calendar,getInstance();

long i = now.getTimeInMillis();

editor.putLong("date", i);

editor.commit();