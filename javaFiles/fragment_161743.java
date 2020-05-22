db.collection("User").document(usernameInput).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Toast.makeText(this, "This username is already taken. Please choose another.", Toast.LENGTH_LONG).show();
            } else {
                Log.d(TAG, "No such document");
            }
        }
    }
});