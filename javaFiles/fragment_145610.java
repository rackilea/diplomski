FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String userid=user.getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("Users").child(userid).child("properties");
usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
   for(DataSnapshot datas: dataSnapshot.getChildren()){
       String desc=datas.child("description").getValue().toString();
       String type=datas.child("type").getValue().toString();
      //get other items
 }
}
@Override
public void onCancelled(DatabaseError databaseError) {
 }
});