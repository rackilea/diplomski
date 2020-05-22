public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
    if (e != null) {
        Log(TAG, "Listen failed.", e);
        return;
    }

    if (documentSnapshot.exists()){
        String semester=documentSnapshot.getString("sem");
        sem.setText(semester);
    }
}