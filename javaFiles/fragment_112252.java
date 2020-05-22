//Pseudocode
SharedPreferences loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
if (loginPreferences.contains("loginEmail")) { //How can I ask here?
  Intent intentMain = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
  LoginActivity.this.startActivity(intentMain);
  finish();
} else {
  //Set the shared preferences
}