dbref = FirebaseDatabase.getInstance().getReference("rechev-6c");
String property = "MISPAR RECHEV|TAARICH||HAFAKAT TAG|SUG TAG"
Query query = dbref.orderByChild(property).equalTo("04932564")

query.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
      System.out.println(snapshot.getKey()); // 99099, or similar
      System.out.println(snapshot.child(property).getValue(String.class)); 
    }
 }

  @Override
  public void onCancelled(DatabaseError databaseError) {
    throw databaseError.toException();
  }
}