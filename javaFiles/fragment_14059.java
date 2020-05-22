StorageReference filepath= storageReference.child("Images").child(filePath.getLastPathSegment());
    filepath.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            Uri downloadUrl = taskSnapshot.getDownloadUrl();
            img.child("image").setValue(downloadUrl);

        }