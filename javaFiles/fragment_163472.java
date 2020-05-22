public void importSchedule(String ownerName){

    DatabaseReference events = FirebaseDatabase.getInstance().getReference("Events").child(pushedKey);
    Query allOwnersEvents = events.equalTo(ownerName);

    allOwnersEvents.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot post : dataSnapshot.getChildren()) {
        String allDay = post.child("yourFiedName").getValue(String.class);
        }
    }
    public void onCancelled(DatabaseError databaseError) {}
});