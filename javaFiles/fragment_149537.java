db.collection("streets").document("São Paulo").collection("street").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Log.d(TAG, document.getString("city"));
            }
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});