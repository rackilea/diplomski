FirebaseDatabase database = FirebaseDatabase.getInstance(); // get the reference of child containing testitems
DatabaseReference myRef = database.getReference();

myRef.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot snap: dataSnapshot.getChildren()) {
        Log.e(snap.getKey(),snap.getChildrenCount() + "");
    }
}

@Override
public void onCancelled(DatabaseError databaseError) {

}
});