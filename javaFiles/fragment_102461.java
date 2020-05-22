/**
   * Example of reading a blob's content through a reader.
   */
  // [TARGET reader(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public void readerFromStrings(String bucketName, String blobName) throws IOException {
    // [START readerFromStrings]
    try (ReadChannel reader = storage.reader(bucketName, blobName)) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
    // [END readerFromStrings]
  }