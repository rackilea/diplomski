StorageReference filepath= storageReference.child("Images").child(filePath.getLastPathSegment());
    filepath.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            String downloadUrl = taskSnapshot.getDownloadUrl().toString()
            img.child("image").setValue(downloadUrl);

        }