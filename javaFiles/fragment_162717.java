DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users");
ref.orderByChild("username").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener(){
@Override
public void onDataChange(DataSnapshot dataSnapshot){
  if(dataSnapshot.exist() {
     //username exist
      }
    }