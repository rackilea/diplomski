public static SharedPreferences getSharedPreferences(Activity activity) {
        SharedPreferences prefs = activity.getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY,
                Context.MODE_PRIVATE);
        long lastUpdate = prefs.getLong("lastUpdate", 0);
        Context packageContext;
        for (String app : new String[] { "app1", "app2", "app3", "app4", "app5", "app6" }) {
            try {
                packageContext = activity.createPackageContext(SHARED_PREFS_KEY + "." + app, 0);
                SharedPreferences sharedPrefs = packageContext.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
                long sharedLastUpdate = sharedPrefs.getLong("lastUpdate", 0);
                if (sharedPrefs != null && sharedLastUpdate > lastUpdate) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.clear();
                    for (Map.Entry<String, ?> entry : sharedPrefs.getAll().entrySet()) {
                        if (entry.getValue() instanceof Boolean)
                            editor.putBoolean(entry.getKey(), (Boolean) entry.getValue());
                        else if (entry.getValue() instanceof Float)
                            editor.putFloat(entry.getKey(), (Float) entry.getValue());
                        else if (entry.getValue() instanceof Integer)
                            editor.putInt(entry.getKey(), (Integer) entry.getValue());
                        else if (entry.getValue() instanceof Long)
                            editor.putLong(entry.getKey(), (Long) entry.getValue());
                        else if (entry.getValue() instanceof String)
                            editor.putString(entry.getKey(), (String) entry.getValue());
                    }
                    editor.commit();
                    break;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return prefs;
    }