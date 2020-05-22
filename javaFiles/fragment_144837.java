SharedPreferences preferences = getSharedPreferences("name", MODE_PRIVATE);
SharedPreferences.Editor editor = preferences.edit();
Gson gson = new Gson();
String serializedObj = gson.toJson(ObjectHere);
editor.putString("key", serializedObj);
editor.commit();