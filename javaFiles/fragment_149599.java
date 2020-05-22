onResume() { // onCreate() should work, too.
   if (loggedIn) {
        startActivity(new Intent(this, LoggedInActivity.class));
   } else {
        // send them to login
   }
}