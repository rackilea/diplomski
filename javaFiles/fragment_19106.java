// Read from the database
mRootReference.addListenerForSingleValueEvent (new ValueEventListener() { 
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        Iterator<DataSnapshot> children = dataSnapshot.getChildren().iterator(); 

        TextView[] views = new TextView[] {
            mRolll,
            mRoll2,
            mRoll3,
            mRoll4,
            mRoll5,
            mRoll6,
            mRoll7,
            mRoll8,
        }

        for (int i = 0; i < views.length && children.hasNext(); i++) {
            views[i].setText(children.next().getKey());
        }
    }
    @Override
    public void onCancelled(@NonNull DatabaseError error) { 
        //Failed to read value
    }
});