ParseUser currentUser = ParseUser.getCurrentUser();

if (currentUser != null) {
    Log.e("currentUser" , ""+currentUser);
    String username = user.getString("username");
    String gender = user.getString("gender");
} else {
    // show the signup or login screen
}