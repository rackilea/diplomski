final FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference ref = database.getReference("server/NodeOfTheUser");    
ref.addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    //your code to go to the next activity
  }

});