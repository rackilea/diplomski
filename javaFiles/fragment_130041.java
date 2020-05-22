reference.orderByChild("name").equalTo(user.getName()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if(dataSnapshot.exists())
                             // do what you want
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                  )};