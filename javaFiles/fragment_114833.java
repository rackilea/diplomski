SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); 
Boolean isUserRegistered = prefs.getString("userRegistered", false); //False is a default value
if (isUserRegistered) {
  startActivity(new Intent(this,Login.class));
}
else{
  startActivity(new Intent(this,Register.class));
} 

//Shorter way
startActivity(isUserRegistered ? new Intent(this,Login.class) : new Intent(this,Register.class));