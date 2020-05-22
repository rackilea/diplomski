public void authenticateUser(final String mEmail, final String mPassword){

        final String email = mEmail.replace(" ","");
        final String password = mPassword.replace(" ","");

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(DriverLoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {

                        Toast.makeText(DriverLoginActivity.this, "sign in error", Toast.LENGTH_SHORT).show();
                    } else
                        mAuth.addAuthStateListener(firebaseAuthListener);
                }
            });

        }

    }