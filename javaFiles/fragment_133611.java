FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
DocumentReference docRef = rootRef.collection("yourCollection").document("yourDocument");
docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
                Log.d(TAG, String.valueOf(map.size()));
            }
        }
    }
});