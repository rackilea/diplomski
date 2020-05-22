String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("Users").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String age = dataSnapshot.child("age").getValue(String.class);
        String name = dataSnapshot.child("name").getValue(String.class);
        String sex = dataSnapshot.child("sex").getValue(String.class);
        Log.d("TAG", name + ", " + sex + ", " + age);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d("TAG", databaseError.getMessage()); //Don't ignore errors!
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);