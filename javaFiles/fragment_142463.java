User myUser= new User("a", "b", 2);
SharedPreferences.Editor prefsEditor = mPrefs.edit();
Gson gson = new Gson();
String json = gson.toJson(myUser);
prefsEditor.putString(myUser.getUserPhone(), json);
prefsEditor.commit();