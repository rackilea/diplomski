mAuth.signInAnonymously()
     .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
       @Override
       public void onComplete(@NonNull Task<AuthResult> task) {
         if (task.isSuccessful()) {
           FirebaseDatabase database = FirebaseDatabase.getInstance();
           DatabaseReference myRef = database.getReference("message");
           myRef.setValue("Hello, World!");
         }
       }
     });