DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference reference = database.child("Driver2").child("Device_id_here").child("coordinates").child("date_here");

reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {  
     for(DataSnapshot data : dataSnapshot.getChildren()){
       String latitude=data.child("latitude").getValue().toString();
         String longs=data.child("longitude").getValue().toString();
         Log.i("latitude", latitude);
         Log.i("longtitude",longs);
    }
    }
     @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});