DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
ref.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
            snapshot.getRef().child("key").setValue("hisoka");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
}