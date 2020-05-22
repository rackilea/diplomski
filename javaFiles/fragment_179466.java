ref = FirebaseDatabase.getInstance().getReference("Users").child(currentuser).child("Teams");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               for(DataSnapshot ds : dataSnapshot.getChildren()){

                String name = ds.child("name").getValue(String.class);
                a = (TextView)findViewById(R.id.test1);
                a.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
              throw databaseError.toException();
            }


        });