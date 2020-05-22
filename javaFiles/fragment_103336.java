user.readUserDataFromFirebase(new Runnable() {
    public void run() {
        user.writeDataToFirebase();
    }
});

public void readUserDataFromFirebase(Runnable onLoaded){
    refUserTree = new Firebase(FIREBASE_URL + "Users");
    refUserTree.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            UserFirebase = dataSnapshot.getValue(UserFirebase.class);
            onLoaded.run();
        }
        @Override
        public void onCancelled(FirebaseError firebaseError) {}
    });
};