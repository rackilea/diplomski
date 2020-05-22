String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference favoriteRef = rootRef.collection("usersFavorite").document(uid).collection("Favorite");
favoriteRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Log.d("TAG", document.getString("id"));
            }
        } else {
            Log.d("TAG", task.getException().getMessage());
        }
    }
});