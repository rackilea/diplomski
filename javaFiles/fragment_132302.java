final String log_child = login_text.getText().toString();
final String pass_child = pass_text.getText().toString();
mDatabase = FirebaseDatabase.getInstance().getReference("usuarios").child(log_child);

mDatabase.addValueEventListener(new ValueEventListener() {
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot data : dataSnapshot.getChildren()){
        String mpass = data.getValue().toString();
        pass = mpass;
        if(pass.equals(pass_child)){
            //code here
         }
        }
   }

 @Override
 public void onCancelled(DatabaseError databaseError) {
        }
 });