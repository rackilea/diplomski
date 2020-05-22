String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("users").child(uid);
ValueEventListener eventListener = new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    if(!dataSnapshot.exists()) {
        //create new user
    }
}

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(eventListener);