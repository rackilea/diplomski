DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users"); // or whatever your node is
Query query = ref.orderByChild("account").equalTo("goshan164@gmail.com");
query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
            System.out.println(userSnapshot.getKey());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
}