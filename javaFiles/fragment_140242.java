DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference moviesRef = rootRef.child("movies");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String Image = ds.child("Image").getValue(String.class);
            String Link = ds.child("Link").getValue(String.class);
            String Title = ds.child("Title").getValue(String.class);
            int Views = ds.child("Image").getValue(Integer.class);
            Log.d("TAG", Image + "/" + Link + "/" + Title + "/" + Views);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
moviesRef.addListenerForSingleValueEvent(eventListener);