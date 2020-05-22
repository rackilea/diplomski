String provider = ...;  // openstack-swift or transient
BlobStoreContext context = ContextBuilder.newBuilder(provider)
            .endpoint(endpoint)
            .credentials(user, password)
            .buildApi(BlobStoreContext.class);
BlobStore blobStore = context.getBlobStore();
// interact with blobStore, e.g., get, put
...
context.close();