DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference productsRef = rootRef.child("Products");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String NDB_number = ds.child("NDB_number").getValue(String.class);
            String ingredients_english = ds.child("ingredients_english").getValue(String.class);
            String long_name = ds.child("long_name").getValue(String.class);
            Log.d(TAG, NDB_number + " / " + ingredients_english + " / " + long_name);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
productsRef.addListenerForSingleValueEvent(valueEventListener);