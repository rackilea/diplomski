ref.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
       //parse data to recycler view adapter and call notifyDatasetChange()
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});