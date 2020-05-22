SharedPreferences prefs = getSharedPreferences("MyPreference", MODE_PRIVATE);

// On first run:
SharedPreferences.Editor editor = prefs.edit();
if(!prefs.contains("key1"))
    editor.putString("key1", "defaultValue1");
if(!prefs.contains("key2"))
    editor.putString("key2", "defaultValue2");
editor.commit();

// On save:
SharedPreferences.Editor editor = prefs.edit();
editor.putString("key1", "value1");
editor.putString("key2", "value3");
editor.commit();

// On read:
String value1 = prefs.getString("key1");
String value2 = prefs.getString("key2");