public void saveToSharedPreferences(String firstName, String lastName, String photoUrl) {

    // declare your sharedpreferences and editor variables
    SharedPreferences sharedPreferences = context.getSharedPreferences("USER", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    // save your values
    editor.putString("firstName", firstName);
    editor.putString("lastName", lastName);
    editor.putString("photoUrl", photoUrl);

    // commit your changes
    editor.apply();

}