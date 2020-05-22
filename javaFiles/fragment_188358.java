SharedPreferences prefs = getSharedPreferences("your_key", Context.MODE_PRIVATE); 
boolean visited = prefs.getBoolean("welcome");
if (visited) {
    Intent goToNextActivity = new Intent(getApplicationContext(), SomeActivity.class);
    startActivity(goToNextActivity);
}