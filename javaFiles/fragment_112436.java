DatabaseReference ref = database.getReference("Posts/Post");

            // Attach a listener to read the data at our posts reference
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Posts  post = postSnapshot.getValue(Posts .class);
                        //postSnapshot.getKey(); THIS IS YOUR UNIQUE KEY
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });