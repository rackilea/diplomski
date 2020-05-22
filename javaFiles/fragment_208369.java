DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference itemsRef = rootRef.child("Items");
Query query = itemsRef.orderByChild("Name").equalsTo("super Creamcracker");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String category = ds.child("Category").getValue(String.class);
            long price = ds.child("Price").getValue(Long.class);
            Log.d("TAG", category + " / " + price);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);