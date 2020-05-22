//get the value
 SharedPreferences settings = getSharedPreferences("prefs", 0);
 int test = settings.getInt("test", -1); 
 test++;
 SharedPreferences.Editor editor = settings.edit();
 editor.putInt("test", test);
 editor.apply();