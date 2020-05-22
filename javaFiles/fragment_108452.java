// Sign the user in
mAuth.signInWithEmailAndPassword(email, password)
   .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        // TODO: Figure out how to give back certain messages
        // If the task fails
        if(!task.isSuccessful()){
            Log.i(TAG, "Username/Passowrd Combination dont match");
        }
    }
});