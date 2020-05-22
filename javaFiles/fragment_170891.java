DatabaseReference reference = database.getReference("openGames");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
         int nodes = (int) dataSnapshot.getChildrenCount();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}