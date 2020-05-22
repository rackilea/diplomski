DatabaseReference iosRef = FirebaseDatabase.getInstance().getReference("DriversOnline/iosDriver");
iosRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot driverSnapshot: dataSnapshot.getChildren()) {
            String driverid = driverSnapshot.getKey();

            DataSnapshot isOnlineSnapshot = driverSnapshot.child("isOnline");

            System.out.println(isOnlineSnapshot.getValue(String.class));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});