DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference commandsRef = rootRef.child("drones").child("commands");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            boolean executed = ds.child("executed").getValue(Boolean.class);
            String text = ds.child("text").getValue(String.class);
            double timestamp = ds.child("timestamp").getValue(Double.class);
            Log.d("TAG", executed + " / " + text + " / " + timestamp);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
commandsRef.addListenerForSingleValueEvent(eventListener);