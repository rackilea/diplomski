FirebaseUser user = mAuth.getCurrentUser();
String userID = user.getUid();
DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");

ref.child(userID).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            String gender=dataSnapshot.child("gender").getValue().toString();
            if(gender.equals("male")) {
                textViewUserEmail.setText("Hello Sir, your mail is: " + user.getEmail());
            } else {
                textViewUserEmail.setText("Hello Madam, your mail is: " + user.getEmail());
            }
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {}
    });
}