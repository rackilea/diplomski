String name=editText.getText().toString();
int age=Integer.valueOf(editAge.getText().toString());
String gender=editGender.getText().toString();

FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String userId=user.getUid();
DatabaseReference ref=FirebaseDatabase.getInstance().getReference("user").child(userId);
ref.child("name").setValue(name);
ref.child("age").setValue(age);
ref.child("gender").setValue(gender);