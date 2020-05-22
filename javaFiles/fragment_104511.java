private String getUser(){
    firestore.collection("user").document("UID")
            .get()
            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        // just fetch data
                    } else {
                        //write data
                    }
                }
            })
        //    .addOnFailureListener()