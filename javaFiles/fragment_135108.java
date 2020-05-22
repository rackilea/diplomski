FirebaseDatabase.getInstance().getReference().child("clubs").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    System.out.println(dataSnapshot.getChildrenCount());
                    for(DataSnapshot array : dataSnapshot.getChildren()){
                        clubs = array.getValue(BDClub[].class);
                        for(BDClub c : clubs){
                            list.add(c);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });