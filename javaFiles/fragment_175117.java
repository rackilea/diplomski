DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users").child("User1").child("MSG_TYPE_SENT");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnapshot datas: dataSnapshot.getChildren()){
     String msgContent=datas.child("msgContent").getValue().toString();
     String msgType=datas.child("msgType").getValue().toString();
    }
  }
 @Override
public void onCancelled(DatabaseError databaseError) {
    }
 });