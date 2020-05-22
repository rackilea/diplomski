DatabaseReference journalRef =FirebaseDatabase.getInstance().getReference();
journalRef.child("users").child(userID).child("journals").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        journalArrayList.clear();
        for (DataSnapshot journalDS : dataSnapshot.getChildren()) {
            Journal journal = journalDS.getValue(Journal.class);
            journalArrayList.add(journal);
        }
        gridViewAdapter = new GridViewAdapter(MainActivity.this, journalArrayList);
        gridView.setAdapter(gridViewAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
    }
});