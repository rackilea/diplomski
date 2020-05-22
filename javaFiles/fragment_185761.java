DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference sorularRef = rootRef.child("Sinav-01").child("Sorular");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.getKey();
            Log.d("TAG", name);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
sorularRef.addListenerForSingleValueEvent(eventListener);