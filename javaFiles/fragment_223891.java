// Returns a Uri of the form gs://bucket/path that can be used
// in future calls to getReferenceFromUrl to perform additional
// actions
private String niceRefLink (String date){
    // Points to the root reference
    StorageReference storageRef = FirebaseStorage.getInstance().getReference();
    StorageReference dateRef = storageRef.child("/" + date+ ".csv");
    return dateRef.toString();
}