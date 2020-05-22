// save data
SharedPreferences sharedpreferences = getSharedPreferences("yourPreferenceName", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedpreferences.edit();
editor.putString("username", "not logged in");
editor.commit();

// retrieve data
SharedPreferences sharedpreferences = getSharedPreferences("yourPreferenceName", Context.MODE_PRIVATE);
String test = sharedpreferences.getString("username", "not logged in");