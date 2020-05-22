void getData() {

    mFirebaseFirestore.collection("Events").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {
                List<String> list = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    list.add(document.getId());
                }
                Log.d(TAG, list.toString());
                updateData(list); // *** new ***
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        }
    });

}

void updateData(ArrayList list) {

    // Get a new write batch
    WriteBatch batch = db.batch();

    // Iterate through the list
    for (int k = 0; k < list.size(); k++) {

        // Update each list item
        DocumentReference ref = db.collection("Events").document(list.get(k));
        batch.update(ref, "field_you_want_to_update", "new_value");

    }

    // Commit the batch
    batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            // Yay its all done in one go!
        }
    });

}