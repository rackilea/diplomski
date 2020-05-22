private void deleteTask (final String userName){

    final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("All_USER");
    reference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot ds :dataSnapshot.getChildren()){
                if(ds.child("NewUser").child("userName").getValue(String.class).equals(userName)){
                    ds.child("NewUser").child("userName").getRef().removeValue();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }


    });
}