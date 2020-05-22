DatabaseReference drTest = FirebaseDatabase.getInstance().getReference("cours");

drTest.orderByChild("date_cours").equalTo("01/10/2018")
        .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.i("Tag", "test1");

                for (DataSnapshot postsnapshot :dataSnapshot.getChildren())  {
                    Log.i("Tag", "test2");
                    String key = postsnapshot.getKey();
                    postsnapshot.getRef().removeValue();
                }

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG: ", databaseError.getMessage());
            }

        });