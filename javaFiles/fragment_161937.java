DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("KyEpOpqClj_sE2ktP1");
ref.addValueEventListener(new ValueEventListener(){
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
      String value=dataSnapshot.child("Metal").getValue().toString();
      String height=dataSnapshot.child("Height").getValue().toString();
      String diameter=dataSnapshot.child("Diameter").getValue().toString();
      String literage=dataSnapshot.child("Literage").getValue().toString();
  }

 @Override
 public void onCancelled(FirebaseError firebaseError) {


 }
 });