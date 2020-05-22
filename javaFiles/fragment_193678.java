DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference commandsRef = rootRef.child("drones").child("commands");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            CommandObject commandObject = ds.getValue(CommandObject.class);
            Log.d("TAG", commandObject.getExecuted() + " / " + 
                commandObject.getText() + " / " + 
                commandObject.getTimestamp());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
commandsRef.addListenerForSingleValueEvent(eventListener);