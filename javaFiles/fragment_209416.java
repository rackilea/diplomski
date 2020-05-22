DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("Users");
ref.addValueEventListener(new ValueEventListener(){
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String phonenumber=datas.child("phonenumber").getValue().toString();

   }
} 

  @Override
public void onCancelled(FirebaseError firebaseError) {
   }
});