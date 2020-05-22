ref.child(uidKeys).child(uid).child("history").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
            System.out.println(snapshot.child("value").getValue(Long.class));
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});