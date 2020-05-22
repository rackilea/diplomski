FirebaseDB.batch.child(batch).addValueValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //Update recyclerview here
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });