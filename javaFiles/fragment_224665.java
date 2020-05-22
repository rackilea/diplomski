q.addValueEventListener(
        new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // for example: if you're expecting your user's data as an object of the "User" class.
                User user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // read query is cancelled.
            }
        });