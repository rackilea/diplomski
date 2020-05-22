if(PrefUtilities.with(this).isUserLogedin()){

   Intent intent = new Intent(SLogin.this, StudentCP.class);
        intent.putExtra(STUDENT_EMAIL, email);
        startActivity(intent);
}