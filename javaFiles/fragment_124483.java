mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            // Sign in is successful
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name).build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Customer info = new Customer(name, email, address, number, gender);
                                FirebaseDatabase.getInstance().getReference("Customer")
                                    .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                    .setValue(info).addOnCompleteListener(new OnCompleteListener < Void > () {
                                        @Override
                                        public void onComplete(@NonNull Task < Void > task) {
                                            regProgressBar.setVisibility(View.VISIBLE);
                                            Toast.makeText(RegisterActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), Home.class));
                                        }
                                    });
                            }
                        }
                    });
        }
    });
}