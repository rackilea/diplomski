String email=inputEmail.getText().toString().trim();
String password=inputconPassword.getText().toString().trim();
FirebaseUser currentUser= task.getResult().getUser();
String userid=currentUser.getUid();
DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
ref.child("email").setValue(email);
ref.child("password").setValue(password);