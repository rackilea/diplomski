DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference playersRef = rootRef.child("Players");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String typeOfPlayer = ds.getKey();
            Log.d("TAG", typeOfPlayer);

            for(DataSnapshot dSnapshot : dataSnapshot.child(typeOfPlayer).getChildren()) {
                String player = dSnapshot.getKey();
                Log.d("TAG", "    " + player);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
playersRef.addListenerForSingleValueEvent(valueEventListener);