SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(app);
// get the current in value or 0 if it's not set
int anInt = preferences.getInt("MY_INT", 0 /* default value */);
// blah
// save the incremented int.
preferences.edit().putInt("MY_INT", anInt++).commit();