//Get all the sums and display. 
FirebaseDatabase.getInstance().getReference().child("poin").child(stringdate).child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            long sum = 0;
            for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
                if (snapShot.exists()) {
                    long size = snapShot.child("score").getValue(Long.class);
                    sum += size;
                    textViewTotal.setText(String.valueOf(sum));

                }

            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});