mButton = (Button) findViewById(R.id.bCreateAccSignUp);
    mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String UserName = etUserName.getText().toString();
            String PassWord = etPassWord.getText().toString();
            String Email = etEmail.getText().toString();
            //Toast.makeText(this, "Signing up...", Toast.LENGTH_SHORT).show();
            new SignupActivity(CreateAccount.this).execute(UserName, PassWord, Email);
        }
    });