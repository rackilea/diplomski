final long count;
DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
ref.child("postagens-curtidas").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            count = dataSnapshot.getChildrenCount();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });