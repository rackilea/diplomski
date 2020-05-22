String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference table2Ref = rootRef.child("table-2");
DatabaseReference uidRef = table2Ref.child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long currentUserTimestamp = dataSnapshot.child("timestamp").getValue(Long.class);
        String currentUserKey = dataSnapshot.getKey();

        DatabaseReference currentUserKeyRef = rootRef.child("data1").child(currentUserKey);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String userKey = ds.getKey();

                    DatabaseReference userKeyRef = table2Ref.child(userKey);
                    ValueEventListener listener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot d : dataSnapshot.getChildren()) {
                                long timestamp = d.child("timestamp").getValue(Long.class);
                                if(currentUserTimestamp > timestamp) {
                                    //Do something
                                } else {
                                    //Do something else
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                        }
                    };
                    userKeyRef.addListenerForSingleValueEvent(listener);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        currentUserKeyRef.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);