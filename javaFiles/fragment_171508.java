DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("kos_putra");
ref.addValueEventListener(new ValueEventListener(){
  @Override
public void onDataChange(DataSnapshot dataSnapshot){
  for(DataSnapshot data: dataSnapshot.getChildren()){
       String deskripsi=data.child("deskripsi").getValue().toString();
       String nama=data.child("nama").getValue().toString();
    }
  }
      @Override
   public void onCancelled(FirebaseError firebaseError) {

        }
   });