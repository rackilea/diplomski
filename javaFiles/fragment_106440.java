DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  void onDataChange(DataSnapshot snapshot) {
    if (snapshot.hasChild("name")) {
      // run some code
    }
  }
});