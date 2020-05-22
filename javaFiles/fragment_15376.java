SharedPreferences prefs = getSharedPreferences("YourPrefsFile", MODE_PRIVATE); 
String restoredText = prefs.getString("text", null);
if (restoredText != null) {
  String name = prefs.getString("name", "");
  int idName = prefs.getInt("idName", 0);
}