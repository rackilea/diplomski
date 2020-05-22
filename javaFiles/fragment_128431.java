DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
 DatabaseReference mostafa = ref.child("Users").child("mostafa_farahat22@yahoo.com").child("_email");

 mostafa.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
    String email = dataSnapshot.getValue(String.class);
    //do what you want with the email 
 }

 @Override
 public void onCancelled(DatabaseError databaseError) {

 }
 });