FirebaseDatabase db = FirebaseDatabase.getInstance();
DatabaseReference ref = db.getReference();

ref.addChildEventListener(new ChildEventListener() {
@Override
public void onChildAdded(DataSnapshot dataSnapshot, String s) {
    Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");
}

@Override
public void onChildChanged(DataSnapshot dataSnapshot, String s) {

}

@Override
public void onChildRemoved(DataSnapshot dataSnapshot) {

}

@Override
public void onChildMoved(DataSnapshot dataSnapshot, String s) {

}

@Override
public void onCancelled(DatabaseError databaseError) {

}
});