@Override
    public void onClick(View view) {
       String usernameVal_login = usernameEditText_login.getText().toString();
       String passwordVal_login = passwordEditText_login.getText().toString();

        ParseUser.logInInBackground(usernameVal_login, passwordVal_login, new LogInCallback() {
            @Override
            public void done(ParseUser user, com.parse.ParseException e) {
                if (user != null) {
                    Intent intent = new Intent(WelcomeActivity.this, FunFactsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(WelcomeActivity.this, "There was an unexpected error.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }enter code here