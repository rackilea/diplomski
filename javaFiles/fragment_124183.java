holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      name = dataSnapshot.child("Name").getValue().toString();
                      Intent intent = new Intent(getActivity(), Chat.class);
                      intent.putExtra("Recievers_Id", user_id);
                      intent.putExtra("Recievers_Name", name);

                      startActivity(intent);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });