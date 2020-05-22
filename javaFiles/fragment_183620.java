public static String writeFile(byte[] content, String filename, String partnerId, String dateOfReport) {
    Storage storage = StorageOptions.defaultInstance().service();
    BlobId blobId = BlobId.of("dbm-poc", partnerId + "/" + dateOfReport + "-" + filename + ".csv");
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("binary/octet-stream").build();
    storage.create(blobInfo, content);

    return filename;
}

public static byte[] readFile(String filename) throws IOException {
    return Files.readAllBytes(Paths.get(filename));
}