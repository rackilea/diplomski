FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String userid=user.getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("Users");
ref.orderByChild("userid").equalTo(userid).addValueEventListener(new ValueEventListener(){
  @Override
public void onDataChange(DataSnapshot dataSnapshot) {
 for(DataSnapshot datas: dataSnapshot.getChildren()){
    String phone=datas.getKey();
  }
} 

 @Override
public void onCancelled(FirebaseError firebaseError) {
   }
 });