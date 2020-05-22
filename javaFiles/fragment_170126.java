mCreateBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String username = musername.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(registerActivity.this, "Cannot sign you in. Please check the form and try again",
                    Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            Toast.makeText(registerActivity.this, "Password must be at least 6 characters",Toast.LENGTH_LONG).show();
        } else if (email_exists == true) {
            Toast.makeText(registerActivity.this, "Email already exists",Toast.LENGTH_LONG).show();
        } else {
            checkifUsernameExists(username, email, password);
        }

    }
});

private void checkifUsernameExists(final String username, final String email, final String password) {

    Query usernameQuery = FirebaseDatabase.getInstance().getReference().child("users").orderByChild("username").equalTo(username);
    usernameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                // the username is already in the database
                Toast.makeText(registerActivity.this, "Username already exists", Toast.LENGTH_LONG).show();
            }else {
                message.setTitle("Registering user");
                message.setMessage("Pleases wait while we create your account");
                message.setCanceledOnTouchOutside(false);
                message.show();
                registerUser(username, email, password);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}