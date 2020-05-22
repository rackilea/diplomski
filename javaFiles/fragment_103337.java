readUserDataFromFirebase(new UnaryOperator<UserFirebase>() {
    public UserFirebase apply(UserFirebase user) {
        user.writeDataToFirebase();
    }
});

public static void readUserDataFromFirebase(String userID, UnaryOperator<UserFirebase> onLoaded){
    refUserTree = new Firebase(FIREBASE_URL + "Users");
    refUserTree.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            UserFirebase user = dataSnapshot.getValue(UserFirebase.class);
            onLoaded.apply(user);
        }
        @Override
        public void onCancelled(FirebaseError firebaseError) {}
    });
};