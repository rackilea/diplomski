FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
String uid = firebaseUser.getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("Users").child(uid);
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String Displayname = dataSnapshot.child("Displayname").getValue(String.class);
        Log.d("Testing: ", Displayname);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(eventListener);