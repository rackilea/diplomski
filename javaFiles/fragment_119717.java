public void saveToFirebase() {
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Email").push();

    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    UserInformation userInformation = new UserInformation(email, mLastLocation.getLatitude(), mLastLocation.getLongitude());

    ref.setValue(userInformation);
}