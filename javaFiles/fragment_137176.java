public void userExists(String uid) {
  FirebaseFirestore db = FirebaseFirestore.getInstance();
  DocumentReference docRef = db.collection("users").document(uid);
  docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot documentSnapshot = task.getResult();
            if (documentSnapshot.exists()) {
                //Fill layout with the user data and the user linked document data

                //USER DATA
                txvNombre=findViewById(R.id.nombrePerfil);
                txvNombre.setText(user.getDisplayName());
                imvAvatar=findViewById(R.id.imvVistaPerfilAvatar);
                Picasso.with(VistaPerfilActivity.this)
                        .load(user.getPhotoUrl())
                        .resize(500,500)
                        .centerCrop()
                        .into(imvAvatar);


                //HERE GOES THE DOCUMENT DATA

            }
        }
    }
  });
}