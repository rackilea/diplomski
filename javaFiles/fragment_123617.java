DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
Query q = ref.orderByChild("names").equalTo(Raamon);
q.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String dates=datas.child("data").getValue().toString();
     }
   }   
   @Override 
 public void onCancelled(DatabaseError databaseError) {
      }
  });