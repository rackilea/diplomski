ArrayList<String> list = new ArrayList<String>();
DatabaseReference ref= FirebaseDatabase.getInstance().getReference("User").child("R3").child("medication");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snap: dataSnapshot.getChildren()) {
            list.add(snap.child("id").getValue(String.class));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "onCancelled", databaseError.toException());
    }
});