String phoneNo = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference phoneNoRef = rootRef.child("SuccessfulOrders").child(phoneNo);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        ListView<String> list = new ArrayList<>();
        for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
            for(DataSnapshot ds : dSnapshot.getChildren()) {
                String productName = ds.child("productName").getValue(String.class);
                list.add(productName);
                Log.d("TAG", productName);
            }

            //Do what you need to do with your list.
            Log.d("TAG", list.toString());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
phoneNoRef.addListenerForSingleValueEvent(valueEventListener);