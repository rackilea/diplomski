mdatabaseReference.child("users").orderByKey().equalTo(uid).addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {

  for (DataSnapshot postsnapshot :dataSnapshot.getChildren()) {

    String key = postsnapshot.getKey();
    dataSnapshot.getRef().removeValue();

 }