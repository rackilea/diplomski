saveme.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String givenUsername = usernameEditText.getEditableText().toString();
            String givenPassword = passwordEditText.getEditableText().toString();
            new LoginTask(MainActivity.this, givenUsername, givenPassword).execute();
        }
    });