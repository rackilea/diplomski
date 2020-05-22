databaseReference.addValueEventListener(new ValueEventListener(){
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
      System.out.println("Key="+childSnapshot.getKey()+" Value="+childSnapshot.getValue());
    }
  }

  @Override
  public void onCancelled(DatabaseError databaseError) {
    throw databaseError.toException();
  }
});