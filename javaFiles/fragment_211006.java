public void upload(String imageName) {
    if(imageUri!=null) {
        StorageReference reference=storageReference.child("customers).child(imageName);
        reference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double totalProgress=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                // Toast.makeText(getApplicationContext(),"File uploaded"+(int)totalProgress,Toast.LENGTH_LONG).show();
            }
        });
    }
}