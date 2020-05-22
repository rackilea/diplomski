UserProfile user = new UserProfile (
       weight,
       height
 );

 FirebaseDatabase.getInstance().getReference("Users Profile")
       .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
       .setValue(user)