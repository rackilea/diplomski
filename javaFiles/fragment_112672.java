AuthCredential credential = EmailAuthProvider
    .getCredential("user@example.com", "password1234"); //teacher info

// Prompt the user to re-provide their sign-in credentials
user.reauthenticate(credential)
    .addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            Log.d(TAG, "User re-authenticated.");
        }
    });