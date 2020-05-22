FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference buyersReference = rootRef.collection("Buyers");
Query usersDataQuery = buyersReference.whereEqualTo("referrals.userReferralCode", "123");
usersDataQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                String firstName = document.getString("firstName");
                Log.d(TAG, firstName);
            }
        }
    }
});