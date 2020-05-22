private GridFSUploadOptions createMetadata(DateTime publishTime) {
    final Document metadata = new Document();
    metadata.put("processed", false);
    // metadata.put("publishTime", publishTime.toString());
    return new GridFSUploadOptions().metadata(metadata);
}