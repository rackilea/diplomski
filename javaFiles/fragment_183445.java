StorageReference fileReference = mStorageReference.child("fotos").child(mAuth.getCurrentUser().getUid()).child(filePath.getLastPathSegment())
fileReference.putFile(filePath).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
    @Override
    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
        if (!task.isSuccessful()) {
            throw task.getException();
        }
        return fileReference.getDownloadUrl();
    }
    ...