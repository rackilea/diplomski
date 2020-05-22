DatabaseReference ref=FirebaseDatabase.getInstance().getReference();
ref.addValueEventListener(new ValueEventListener(){
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot data : dataSnapshot.getChildren()){
    String value=data.child("Metal").getValue().toString();
     //retrieve here
   }