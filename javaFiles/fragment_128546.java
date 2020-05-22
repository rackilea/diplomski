DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("Users");
usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
 String name=datas.child("name").getValue().toString();
   //gets data
  }
}
@Override
public void onCancelled(DatabaseError databaseError) {
  }
});