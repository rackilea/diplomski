DocumentReference docRef = db.collection("cities").document("SF");

// Source can be CACHE, SERVER, or DEFAULT.
Source source = Source.CACHE;

// Get the document, forcing the SDK to use the offline cache
docRef.get(source).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
   ...