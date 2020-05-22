// to save  in SharedPreferences in Login
private static final String MyPREFERENCES = "MyPreference";
private SharedPreferences sharedPreferences;
sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
editor.putString("username", "usernameValue");
editor.apply();

//to get data from SharedPreferences in Home Page
private static final String MyPREFERENCES = "MyPreference";
private SharedPreferences sharedPreferences;
sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE); 
String username= SharedPreferences.getString("username", null);