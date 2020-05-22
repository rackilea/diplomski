if (user != null) {
     String uid = user.getUid();
     reference.child(uid).child("uid").setValue(uid);
     reference.child(uid).child("name").setValue(user.getDisplayName());
     reference.child(uid).child("email").setValue(user.getEmail());
     reference.child(uid).child("photo").setValue(String.valueOf(user.getPhotoUrl()));
     startActivity(new Intent(LoginUserActivity.this, ProfilUserActivity.class));
     finish();
 }