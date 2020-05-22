b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//Write your database reference and check in the database for entered mobno.
rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(mobno).exists()){
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, e2.getText().toString());
                    // [END verify_with_code]
                    signInWithPhoneAuthCredential(credential);
                    }
                    else{
                        Toast.makeText(PhoneLogin.this,"No such CUG No. found",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });