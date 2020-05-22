// Read from the database
mRootReference.addListenerForSingleValueEvent (new ValueEventListener() { 
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        Iterator<DataSnapshot> children = dataSnapshot.getChildren().iterator(); 

        mRolll.setText(children.next().getKey());
        mRoll2.setText(children.next().getKey());
        mRoll3.setText(children.next().getKey());
        mRoll4.setText(children.next().getKey());
        mRoll5.setText(children.next().getKey());
        mRoll6.setText(children.next().getKey());
        mRoll7.setText(children.next().getKey());
        mRoll8.setText(children.next().getKey());
    }
    @Override
    public void onCancelled(@NonNull DatabaseError error) { 
        //Failed to read value
    }
});