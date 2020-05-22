SharedPreferences sharedPreferences = getSharedPreferences(login.MyPREFERENCE, Context.MODE_PRIVATE);

String phone = sharedPreferences.getString(PHONE, "");
String pass = sharedPreferences.getString(PASS, "");

if(!phone.isEmpty() && !pass.isEmpty()) {
    // this means ID and passwords are already saved so just start your home activity here
    startActivity(new Intent(context, MainActivity.class));
    finish();
}