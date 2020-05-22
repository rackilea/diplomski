DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();   
 dbRef.child("categories").addSingleValueEventListener(new ValueEventListener() {
   @Override
   public void onDataChange(DataSnapshot dataSnapshot) {
       if (dataSnapshot.exists()) {
           for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String name = snapshot.child("names").getValue().toString();  // it will give names node string

             /// To Fetch Quotes
             DataSnapshot quotesSnapshot = snapshot.child("qoutes");
            for (DataSnapshot quoteSingleSnpashot : quotesSnapshot.getChildren()) {
                 String quote = quoteSingleSnpashot.child("quote").getValue().toString();  // it will give names node string
            }

           }
       }
   }

   @Override
   public void onCancelled(DatabaseError databaseError) {

   }

 });
}