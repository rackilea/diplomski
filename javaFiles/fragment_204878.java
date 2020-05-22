FirebaseAuth.getInstance().verifyIdToken(token)
.addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
    @Override
    public void onSuccess(FirebaseToken decodedToken) {
        cdl.countDown();
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        // log error, ...
        cdl.countDown();
    }
});