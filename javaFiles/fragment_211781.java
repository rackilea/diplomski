String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
 DatabaseReference ref = database.getInstance().getReference("userInfos");

        ref.child(UID).addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot snapshot) {
         UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
            vorname.setText(userInformation.vorname);
            nachname.setText(userInformation.nachname);
            alter.setText(userInformation.alter);
            sprachen.setText(userInformation.sprachen);
      }
      @Override
      public void onCancelled(DatabaseError databaseError) {        
      }
    });