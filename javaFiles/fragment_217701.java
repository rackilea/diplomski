public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
    if (document != null && documentSnapshot.exists()){
        String semester=documentSnapshot.getString("sem");
        sem.setText(semester);
    }
}