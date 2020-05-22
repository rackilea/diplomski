String firstname="",lastname="";
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    callbackManager.onActivityResult(requestCode, resultCode, data);
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == GOOGLE_KEY_CODE) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            assert account != null;
            String google_email = account.getEmail();
            String google_name = account.getDisplayName();
           try {
                    if (google_name != null) {
                        if (!google_name.equalsIgnoreCase("")) {
                            String[] name_array = google_name.split(" ");
                            if (name_array.length > 0) {
                                firstname= name_array[0];
                                lastname = name_array[1];
                            }

                        }
                    } else {
                        // handle the null case in case user does not have display name in gmail account
                google_name = "";
                firstname= "";
                lastname = "";
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            if (google_email != null) {
                loginFromGmail(google_email, firstname, lastname);
                Log.d("google_email", google_email);
                Log.d("google_email", google_name);
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}