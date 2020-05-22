mDatabase.child("PRODUCTS").child("PROD1").addValueEventListener(new ValueEventListener() {
    @Override
 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
       selectedproductprice = dataSnapshot.child("productprice").getValue().toString();
       }

   @Override
 public void onCancelled(@NonNull DatabaseError databaseError) {
   }
  });