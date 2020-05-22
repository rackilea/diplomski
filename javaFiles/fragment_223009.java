DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Posts");
database.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        List<String> dates = new ArrayList<>();
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
            String date = dataSnapshot1.child("date").getValue(String.class);
            dates.add(date);
        }
        Log.d(TAG, dates.toString());
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
});