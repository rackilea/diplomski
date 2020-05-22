DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
Query queries = ref.orderByChild("name").equalTo(name_here);
queries.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                Toast.makeText(HomeActivity.this,"data exists",Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(HomeActivity.this,"No data exists",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });