FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference bulletinRef = rootRef.collection("bulletin");
bulletinRef.whereEqualTo("date", date).whereEqualTo("title", title).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Log.d(TAG, document.getString("title"));
            }
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});