final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
      if(user!=null){ //if user is signed in
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
            finish();
        }
         else{
               Log.i("sign in", not signed in);
            }};