String Str_check = app_preferences.getString("checked", "no");
    if(Str_check.equals("yes"))
    {
String Str_user = app_preferences.getString("username","0" );
    String Str_pass = app_preferences.getString("password", "0");

            UserEditText.setText(Str_user);
           PassEditText.setText(Str_pass);
            check.setChecked(true);
    }
else{
   SharedPreferences.Editor editor = app_preferences.edit();
                    editor.putString("username", "");
                    editor.putString("password", "");
                     editor.commit();
}