auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    LayoutInflater inflater = LayoutInflater.from( SignUpActivity.this );
                    View toastview = inflater.inflate( R.layout.toast_registered, null );
                    Toast toast = new Toast( SignUpActivity.this );
                    toast.setView( toastview );
                    toast.setGravity( Gravity.CENTER, 0, 3 );
                    toast.setDuration( Toast.LENGTH_LONG );
                    toast.show();
                }
                else {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                         Toast.makeText(SignUpActivity.this, "toast1." + task.getException(),
                         Toast.LENGTH_SHORT).show();
                    }
                    else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                         Toast.makeText(SignUpActivity.this, "toast2." + task.getException(),
                            Toast.LENGTH_SHORT).show();
                    }   
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                }
            }
        });