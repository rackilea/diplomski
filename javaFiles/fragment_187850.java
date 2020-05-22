FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if(user != null) {
    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
            .setDisplayName("Developer").build();

    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
                Log.d(TAG, "User profile updated.");
            }
        }
    });
}