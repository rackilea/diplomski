FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String useruid=user.getUid();
DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Accounts").child("user").child(useruid);
ref.child("date").setValue(newdate);
ref.child("email").setValue(newemail);
ref.child("name").setValue(newname);
ref.child("type").setValue(newtype);