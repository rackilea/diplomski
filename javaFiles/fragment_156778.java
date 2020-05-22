DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("Region 1").child("Parameter Reading");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String airTemperature = dataSnapshot.child("airtemperature").getValue(String.class);
        Log.d("TAG", airTemperature);
        //Your logic
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
ref.addListenerForSingleValueEvent(valueEventListener);