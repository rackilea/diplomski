collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                if (document.getString("barCode") != null) {
                    collectionReference.document(document.getId()).update(
                        "productQuantity", FieldValue.increment(1)
                    );
                }
            }
        }
    }
});