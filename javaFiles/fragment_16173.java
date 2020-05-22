DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference playListIdRef = rootRef.child("playlists").child(playListId);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
            long playListIdOne = dataSnapshot.getValue(String.Long);
            Log.d(TAG, "playListIdOne: " + playListIdOne);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
playListIdRef.addListenerForSingleValueEvent(valueEventListener);