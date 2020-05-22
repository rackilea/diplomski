public void userExists(String uid, final UserExistsCallback callback) {
  FirebaseFirestore db = FirebaseFirestore.getInstance();
  DocumentReference docRef = db.collection("users").document(uid);
  docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        boolean userExists = false;
        if (task.isSuccessful()) {
            DocumentSnapshot documentSnapshot = task.getResult();
            userExists = documentSnapshot.exists();
        }
        callback.onCallback(userExists);
    }
  });
}