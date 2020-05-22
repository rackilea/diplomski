String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("users")
DatabaseReference uidRef = usersRef.child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long currentUserTimestamp = dataSnapshot.child("timestamp").getValue(Long.class);
        String currentUserKey = dataSnapshot.getKey();

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    long timestamp = dataSnapshot.child("timestamp").getValue(Long.class);
                    if(currentUserKey != ds.getKey()) {
                        if(currentUserTimestamp > timestamp) {
                            //Do something
                        } else {
                            //Do something else
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        usersRef.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);