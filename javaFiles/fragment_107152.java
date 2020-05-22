mUsername = (EditText) findViewById(R.id.usernameField);
mPassword = (EditText) findViewById(R.id.passwordField);

//Set up Login button
mLoginButton = (Button) findViewById(R.id.loginButton);
mLoginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString(); //this is line 58