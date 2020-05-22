myRef2.addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(DataSnapshot dataSnapshot) {
            Counter counter = dataSnapshot.getValue(Counter.class);
            data.setId(String.valueOf(counter.getCnt_android() + 1));
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Information Android/");
            myRef.child(data.getId()).setValue(data);

        }

        @Override public void onCancelled(DatabaseError databaseError) {
            System.out.println("The read failed: " + databaseError.getCode());
        }
    });