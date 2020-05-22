@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {

         number = getIntent().getExtras().getInt("number");
         saveNumberToSharedPrefs(number);
    }
} 

private void saveNumberToSharedPrefs(int num){
    SharedPreferences preferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE); //Create and store this instance in onCreate method of activity, or use it like this.
    preferences.edit().putInt("NUMBER", num).apply(); // Use constant value for key
}