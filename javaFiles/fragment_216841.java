ContextBuilder builder = ContextBuilder
        .newBuilder("swift")
        .credentials(IDENTITY, CREDENTIAL)
        .endpoint(ENDPOINT);
    BlobStoreContext blobStoreContext = builder.build(
        BlobStoreContext.class);
    BlobStore blobStore = blobStoreContext.getBlobStore();