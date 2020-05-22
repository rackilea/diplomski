protected void onResume() {
    super.onResume();
    // Checking for user session
    // if user is already logged in, take him to main activity
    if (pref.isLoggedIn()) {
       //here, pref is the instance of your preference manager
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        finish();
    }

}