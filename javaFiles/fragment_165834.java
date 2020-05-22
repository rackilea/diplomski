FirebaseDatabase.getInstance().child("username").orderByChild("age").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int sum = 0;
                    for(DataSnapshot data : dataSnapshot.getChildren()){
                        User user = data.getValue(User.class);
                        sum = sum + user.getAge();
                    }
                }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });