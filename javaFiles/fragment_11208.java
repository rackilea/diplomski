private void completeFirebaseAuth(GoogleSignInAccount  acct) {
    AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, new
                    OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "signInWithCredential", task.getException());
                    }
                    // ...
                }
            });
}