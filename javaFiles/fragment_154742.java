private class SignInOnClickListener implements View.OnClickListener {

    public void onClick(View v) {
        // Get the username and password from the view
        final String username_email = mUsernameEmailEtxt.getText().toString().toLowerCase().trim();
        final String password = mPasswordEtxt.getText().toString().trim();
        if (isFormInputValid(username_email, password)) {
            if (username_email.indexOf('@') != -1) {
                ParseQuery<ParseUser> query = ParseUser.getQuery();
                query.whereEqualTo("email", username_email);
                query.getFirstInBackground(new GetCallback<ParseUser>() {
                    public void done(ParseUser object, ParseException e) {
                        if (object == null) {
                            TextView error = (TextView) findViewById(R.id.info);
                            error.setVisibility(View.VISIBLE);
                            error.setText(getString(R.string.error_sign_in));
                            Log.d("error", "The getFirst request failed. Probably because no associated account found");
                        } else {
                            String actualUsername = (String) object.get("username");
                            ParseUser.logInInBackground(actualUsername, password, new LogInCallback() {
                                public void done(ParseUser user, ParseException e) {
                                    if (user != null) {
                                        // Hooray! The user is logged in.
                                        Intent intent = new Intent(getBaseContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        TextView error = (TextView) findViewById(R.id.info);
                                        error.setVisibility(View.VISIBLE);
                                        error.setText(getString(R.string.error_sign_in));

                                        Log.d("error", "email or password  invalid");
                                    }
                                }
                            });
                        }
                    }
                });

            } else {
                Log.d("detector", "username_email detected as username:" + username_email);
                ParseUser.logInInBackground(username_email, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            Intent intent = new Intent(getBaseContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            TextView error = (TextView) findViewById(R.id.info);
                            error.setVisibility(View.VISIBLE);
                            error.setText(getString(R.string.error_sign_in));

                            Log.d("error", "username or password invalid");
                        }

                    }
                });
            }
        }
    }
}