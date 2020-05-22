if (user != null) {
  userExists(user.getUid(), new UserExistsCallback() {
    public void onCallback(boolean isExisting) {
      if(isExisting){
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


      }else{

      }
    } else {
      finish();
    }
  });
}