//autowire storage bean
private final Storage storage;
public StorageService(Storage storage) {this.storage = storage;}
...
BlobId blobId = BlobId.of(StorageClient.getInstance().bucket().getName(), documentPath);
log.info("Deleting document info => " + blobId.toString());
storage.delete(blobId);