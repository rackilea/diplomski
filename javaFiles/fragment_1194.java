public class ImageActions {

public interface OntaskCompleted{
   void onSuccess(Uri returnurl);
   void onfail();
}

private Uri downloadUrl;

public void ImageLoad(final OntaskCompleted listener)
{
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://apptest.appspot.com");

    Uri file = Uri.fromFile(new File("sdcard/DCIM/Camera/1466831822883.jpg"));

    StorageMetadata metadata = new StorageMetadata.Builder().setContentType("image/jpeg").build();

    UploadTask uploadTask = storageRef.child("images/"+file.getLastPathSegment()).putFile(file, metadata);

    uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

        }
    }).addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onPaused(UploadTask.TaskSnapshot taskSnapshot) {
            System.out.println("Upload is paused");
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception exception) {
            // Handle unsuccessful uploads
            listener.onfail();
        }
    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            // Handle successful uploads on complete
            downloadUrl = taskSnapshot.getMetadata().getDownloadUrl();
                  System.out.println("Upload completed");  
            listenr.onSuccess(downloadurl)              
        }
    });

 }
}