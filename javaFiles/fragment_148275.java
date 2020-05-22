//Retrieve the values
Set<String> set = sharedPreferences.getStringSet("key", null);

//Set the values
Set<String> set = new HashSet<String>();
set.addAll(saveGameList);
editor.putStringSet("key", set);
editor.commit();