authStateListener = new FirebaseAuth.AuthStateListener() {

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
          firebaseUser = firebaseAuth.getCurrentUser();

          if (firebaseUser != null) {

          Intent intent = new Intent(Auth1Activity.this, HomeActivity.class);
          startActivity(intent);
          finish();

        }

    }

};