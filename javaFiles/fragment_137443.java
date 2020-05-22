public void addUser(final User user, CustomInterface customInterface){
    final String encodedUserId = Email.encodeID(user.getEmail().getAddress());
    firebaseUsersRef.child(encodedUserId).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            if (snapshot.exists()) {
                customInterface.handleResult(USER_ALREADY_EXISTS); // I assume this is String
            } else {
                Firebase firebaseUserReference = firebaseRef.child(USERS_TABLE).child(encodedUserId);
                firebaseUserReference.setValue(user);
            }
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {
            customInterface.handleResult(FIREBASE_ERROR); // I assume this is String
        }
    });
}