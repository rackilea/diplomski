DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference carpentersRef = rootRef.child("AvailableWorkers").child("Carpenters");
Query query = carpentersRef.orderByChild("rating")
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String g = ds.child("g").getValue(String.class);
            Log.d("TAG", g);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);