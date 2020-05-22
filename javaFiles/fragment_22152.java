String path = "images/"+imgName;
ByteArrayOutputStream baos = new ByteArrayOutputStream();
// this will compress an image that the uplaod and download would be faster
bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
byte[] data = baos.toByteArray();
FirebaseStorage storage = FirebaseStorage.getInstance();
StorageReference storageReference = storage.getReference();
StorageReference reference = storageReference.child(path);
UploadTask uploadTask = reference.putBytes(data);
uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
     @Override
     public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
         Log.i(TAG, "Image was saved");
     }
 }).addOnFailureListener(new OnFailureListener() {
     @Override
     public void onFailure(@NonNull Exception e) {
         Log.e(TAG, "Image wasn't saved. Exception: "+e.getMessage());
     }
 });