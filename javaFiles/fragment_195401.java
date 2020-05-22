DocumentReference docRef = db
    .collection("deyaPayUsers")
    .document(mAuth.getUid())
    .collection("Split")
    .document(mAuth.getUid())
    .collection("SentInvitations")
    .document(documentId); //Reference to a document