DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);

ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
            String name=dataSnapshot.child("Name").getValue().toString();                     


            Name.setText(name);

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
};