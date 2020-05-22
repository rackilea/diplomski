// Attach an listener to read the data at our posts 
usersRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        Log.d(TAG, snapshot.getKey() + " received from firebase");
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        Log.w(TAG, "The read failed: " + firebaseError.getMessage());
    }
 });