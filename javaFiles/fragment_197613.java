public static rmAll(Storage storage, String bucket) {
    StorageBatch batch = storage.batch();
    Page<Blob> blobs = storage.list(bucket, Storage.BlobListOption.currentDirectory());
    for(Blob blob : blobs.iterateAll()) {
        batch.delete(blob.getBlobId());
    }
    batch.submit();
}