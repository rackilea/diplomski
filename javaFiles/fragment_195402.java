DocumentReference docRef = db
    .collection("deyaPayUsers")
    .document(mAuth.getUid())
    .collection("Split")
    .document(mAuth.getUid())
    .collection("SentInvitations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Map<String, Object> map = document.getData();
                String amount = map.get("Amount").toString();
                String phoneNumber = map.get("PhoneNumber").toString();
                String status = map.get("Status").toString();
                System.out.println(amount + " / " + phoneNumber + " / " + status);
            }
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});