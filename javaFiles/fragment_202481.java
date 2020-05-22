DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("Hospital").child("QCH");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String hospitalName = dataSnapshot.child("hospital_name").getValue(String.class);
        String hospitalCode = dataSnapshot.child("hospital_code").getValue(String.class);
        Log.d(TAG, hospitalName + " / " + hospitalCode);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
ref.addListenerForSingleValueEvent(valueEventListener);