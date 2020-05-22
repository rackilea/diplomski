DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query usersQuery = rootRef.child("Users").orderByChild("name").equalTo("ANAND");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String course = ds.child("course").getValue(String.class);
            Log.d(TAG, course);

            Query courseRef = rootRef.child("Course").orderByChild("name").equalTo(course);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        String name = ds.child("name").getValue(String.class);
                        String url = ds.child("url").getValue(String.class);
                        Log.d(TAG, name + " / " + url);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            courseRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
usersQuery.addListenerForSingleValueEvent(valueEventListener);