DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
rootRef.child("Names").orderByChild("Date").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
       for(DataSnapshot ds: dataSnapshot.getChildren()){
        date.add(ds.getValue(String.class));
           }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

//Also as you've told that code is not working, please tell, what exactly is not working