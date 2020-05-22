DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference playersRef = rootRef.child("Players");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String typeOfPlayer = ds.getKey();
            Log.d("TAG", typeOfPlayer);

            DatabaseReference playerRef = playersRef.child(typeOfPlayer);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
                        String player = dSnapshot.getKey();
                        Log.d("TAG", "    " + player);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            playerRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
playersRef.addListenerForSingleValueEvent(valueEventListener);