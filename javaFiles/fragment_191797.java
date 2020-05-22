DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
DatabaseReference answersReference = databaseReference.child("42");
Query query = answersReference.orderByChild("timeTaken");
query.addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot userAnswerSnapshot: dataSnapshot.getChildren()) {
      System.out.println("User "+userAnswerSnapshot.getKey()+" took "+userAnswerSnapshot.child("timeTaken").getValue());
    }
  }