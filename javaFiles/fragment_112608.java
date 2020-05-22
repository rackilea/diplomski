public void getUser(final OnUserResult callback) {
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            User user = dataSnapshot.child("users").child(mUserID).child("user_info").getValue(User.class);
           if (null!=callback) callback.onUser(user);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.d(TAG, "onCancelled: Error: " + databaseError.getMessage());
        }
    });
}