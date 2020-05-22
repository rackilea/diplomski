DatabaseReference myRef= database.getReference("Posts/Post");
    Query query = myRef.orderByChild("title").equalTo("Title2");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });