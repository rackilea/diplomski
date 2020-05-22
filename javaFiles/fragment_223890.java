// Calls the server to securely obtain an unguessable download Url
private void getUrlAsync (String date){
    // Points to the root reference
    StorageReference storageRef = FirebaseStorage.getInstance().getReference();
    StorageReference dateRef = storageRef.child("/" + date+ ".csv");
    dateRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>()
    {
        @Override
        public void onSuccess(Uri downloadUrl) 
        {                
           //do something with downloadurl
        } 
    });
}