public void readData(MyCallback myCallback) {
    DocumentReference mSettings = mFirebaseFirestore.collection("user_account_settings").document(userID);
    mSettings.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {
            UserAccountSettings settings = documentSnapshot.toObject(UserAccountSettings.class);
            myCallback.onCallback(settings);

        }
    });
}