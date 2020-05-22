reference = db.getReference("Attendance");
reference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot idSnapshot: dataSnapshot.getChildren()) {
            System.out.println(idSnapshot.getKey());
            for (DataSnapshot userSnapshot: idSnapshot.getChildren()) {
                System.out.println(userSnapshot.getKey());
                System.out.println(userSnapshot.child("Status/xname").getValue(String.class));
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
}