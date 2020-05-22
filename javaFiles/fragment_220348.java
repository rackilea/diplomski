//In your Activity or Fragment or wherever you call Firebase
        firebaseDatabase.getReference("<top-level-key>")
            .child("L13a")
            .child("answers")
            .child("1")
            .addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    Answer value = dataSnapshot.getValue(Answer.class);
                    //value.getAnswer() = "rstrrs"
                    //value.getVote_Count() = 0
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });