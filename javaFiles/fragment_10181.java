FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference itemsRef = rootRef.collection("yourCollection");
Query query = itemsRef.whereEqualTo("field1", "x").whereEqualTo("field2", "y");
query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                itemsRef.document(document.getId()).delete();
            }
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});