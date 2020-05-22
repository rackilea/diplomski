mAuth = FirebaseAuth.getInstance();

    fireBaseStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(intent);
                finish();
                return;}};

 @Override
   protected void onStart() {
      super.onStart();
      mAuth.addAuthStateListener(fireBaseStateListener);
   }