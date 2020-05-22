private void signOut() {
    FirebaseFirestore.getInstance().signOut(); //Sign-out Firebase

    if (googleApiClient.isConnected()) {
        Auth.GoogleSignInApi.signOut(googleApiClient); //Sign-out Google
    }
}