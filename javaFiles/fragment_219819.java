myFirebaseRef
  .child("Users")
  .child(result.get("uid"))
  .setValue(screenname, new Firebase.CompletionListener() {
    @Override
    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
        if (firebaseError != null) {
            System.out.println("Data could not be saved. " + firebaseError.getMessage());
        } else {
            System.out.println("Data saved successfully.");
        }
    }
});