public class CloudStorageDatabaseUtils {

        public void uploadImage(String storageChildAndPath, File file) {

            Uri uriFile = Uri.fromFile(file);

            StorageReference storageRef = FirebaseStorage.getInstance().getReference();
            final StorageReference ref = storageRef.child(storageChildAndPath);

            ref.putFile(uriFile);

        }

        public void getDownloadURL(String path, UrlReceiver receiver) {

            StorageReference reference = FirebaseStorage.getInstance().getReference().child(path);

            reference.getDownloadUrl().addOnSuccessListener(uri -> receiver.onUrlReceived(uri.toString()));
        }
    }