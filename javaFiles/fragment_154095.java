mDatabase = FirebaseDatabase.getInstance().getReference();
mDatabase.child("Entries").addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot entrySnapshot : dataSnapshot.getChildren()) {
      for (DataSnapshot propertySnapshot : entrySnapshot.getChildren()) {
        System.out.println(propertySnapshot.getKey()+": "+propertySnapshot.getValue(String.class));
      }
    }
  }
  ...