SharedPreference pref = getSharedPreferences("yourPref", MODE_PRIVATE);
String activityName = pref.getString("activityName",null);

if(activityName != null && activityName.equals("FirstActivity")){
 startActivity(new Intent(this,FirstActivity.class));
 finish();
}