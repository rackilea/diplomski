private void loadPreferences()
{
    SharedPreferences settings = getSharedPreferences(PREFS_NAME,
            Context.MODE_PRIVATE);

    if(settings.contains(PREF_UNAME) && settings.contains(PREF_PASSWORD)){
        //you can start the 2nd activity directly here
        //Intent intent = new Intent (...)
        //startActivity(intent);
        //finish();

        //OR

        //load data into edittexts and programatically click the login button
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);

        etemail.setText(UnameValue);
        etpass.setText(PasswordValue);

        //here it will click the button as if the user did it.
        btnLogin.performClick();
    }//contains
}