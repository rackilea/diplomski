Query userQuery = FirebaseDatabase.getInstance().getReference().child("User").child(uid);
userQuery.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String type = dataSnapshot.child("isAdmin").getValue().toString();
        if(type.equals("true")){
            loadMenuBeachAdmin();


            FloatingActionButton fab = (FloatingActionButton) homeView.findViewById(R.id.fab);
            fab.show();

  }
}