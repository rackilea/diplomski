DatabaseReference customer = FirebaseDatabase.getInstance().getReference().child("customer"); 
DatabaseReference driver = FirebaseDatabase.getInstance().getReference().child("driver");
FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if(user!=null){
    customer.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() { 
      @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      if (dataSnapshot.exists() && user != null) { 
            Intent i = new Intent(Activity.this, CustomerActivity.class);
            startActivity(i);
            finish();
      } else {
         driver.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
         public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists() && user != null) {
                Intent i = new Intent(Activity.this, DriverActivity.class);
                startActivity(i);
               finish();
             }
          }
          @Override
        public void onCancelled(DatabaseError databaseError) {}
        });
       }
         @Override
        public void onCancelled(DatabaseError databaseError) {}
       });