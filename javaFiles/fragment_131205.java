DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference("your table name");
 mDatabaseReference.child("table child").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int count = Integer.parseInt(snapshot.child("count").getValue().toString);
                //and update your value
                updateYourCount(count+1); //calling a method
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });