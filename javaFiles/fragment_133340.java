// Create a reference to the Firebase database
Firebase ref = new Firebase("https:<MY-FIREBASE-APP>.firebaseio.com/data");
// Save Data
ref.setValue("Hello"); 
// Sync data
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        System.out.println(snapshot.getValue());
    }
    @Override
    public void onCancelled(FirebaseError firebaseError) {
        System.out.println("The read failed: " + firebaseError.getMessage());
    }
});