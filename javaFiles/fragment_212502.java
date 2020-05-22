private String audioLink;

private void setData() {
    //FireBase Get Details Section
    firebaseFirestore = FirebaseFirestore.getInstance();
    firebaseFirestore.collection("SUBJECT")
            .document(subjectName).collection("CHAPTER")
            .document(chapterName.toUpperCase())
            .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    txtDetails.setText(document.get("chapterDetails").toString());
                    audioLink = document.get("audioLink").toString();//Assigning Value
                 setAudio(); // you need to call if from here 
                } else {
                    txtDetails.setText("Empty");
                }
            } else {
                Log.d("Error", "Cached get failed: ", task.getException());
            }
        }
    });
}