// If value for key not exist then return second param value - In this case null

boolean userFirstLogin= pref.getBoolean("key_name1", true);  // getting boolean
int pageNumber=pref.getInt("key_name2", 0);             // getting Integer
float amount=pref.getFloat("key_name3", null);          // getting Float
long distance=pref.getLong("key_name4", null);          // getting Long
String email=pref.getString("key_name5", null);         // getting String
Deleting Key value from SharedPreferences

editor.remove("key_name3"); // will delete key key_name3
editor.remove("key_name4"); // will delete key key_name4

// Save the changes in SharedPreferences
editor.commit(); // commit changes