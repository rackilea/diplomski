// this variable represents the uId of specific user you want to retrieve the email of
String userId = "INSERT_USERID_HERE";

// add userId above as a child to your databaseReference object
databaseReference = database.getReference("Customers").child("userId");

// valueEventListener call
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String email = dataSnapshot.child("email").getValue().toString();
        Toast.makeText(HomeScreen.this, email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
  });
}