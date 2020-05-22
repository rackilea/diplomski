DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Places");

ref.addValueEventListener(new ValueEventListener(){

   @Override
   public void onDataChange(DataSnapshot dataSnapshot){
    for(DataSnapshot ds : dataSnapshot.getChildren()){
      String key = ds.getKey();
     }
  }