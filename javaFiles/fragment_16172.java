rootRef.collection("songs").document(playListId).collection("playListSongs")
.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            Log.d("TAG", task.getResult().size() + "");
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference playListIdRef = rootRef.child("playlists").child(playListId);
            playListIdRef.setValue(task.getResult().size());

        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});