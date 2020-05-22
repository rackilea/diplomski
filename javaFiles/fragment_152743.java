ChildEventListener childEventListener = new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        //Code the see which item is added
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        //Code the see which item is changed
    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
        //Code the see which item is removed
    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        //Code the see which item is moved
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
yourRef.addChildEventListener(childEventListener);