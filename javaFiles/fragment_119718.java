DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Email");

ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot child : dataSnapshot.getChildren()){
            UserInformation details = child.getValue(UserInformation.class);

            System.out.println("-->" + details.getLatitude() +" " + details.getLongitude() +" "+ details.getEmail());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});