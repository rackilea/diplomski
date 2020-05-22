DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("test"); 
ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {

                score = dataSnapshot.child("Name1").child("score").getValue();

                ...
                // and the rest