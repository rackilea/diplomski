JSONObject jsonObject = new JSONObject(hashmapB);
String jsonString = jsonObject.toString();

SharedPreferences keyValues = getSharedPreferences("Your_Shared_Prefs"), Context.MODE_PRIVATE);
SharedPreferences.Editor editor = keyValues.edit();
editor.putString("hashmapB_key",jsonString);