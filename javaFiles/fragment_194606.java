databaseReference=firebaseDatabase.getInstance().getReference("Catagories/Bussiness");
mupload=new ArrayList<>();`


 databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot post : dataSnapshot.getChildren()) {
            Upload upload=post.getValue(Upload.class);
            mupload.add(upload);
        }
        customQuoteAdapter=new CustomQuoteAdapter( Images.this, mupload);
        recyclerView.setAdapter(customQuoteAdapter);
    }
    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Toast.makeText(getApplicationContext(), "ERROR"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();

    }
});