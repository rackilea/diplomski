DocumentReference docRef = db.collection("challenges").document("yourDocument");
docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {
        Challenge challenge = documentSnapshot.toObject(Challenge.class);
    }
});