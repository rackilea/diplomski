public static String destFilePath = "/path/to/directory/";

public static void main(String[] args)
        throws InvalidKeyException, URISyntaxException, StorageException, IOException {

    CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
    CloudBlobClient serviceClient = account.createCloudBlobClient();
    CloudBlobContainer container = serviceClient.getContainerReference("mycontainer");

    for (ListBlobItem blobItem : container.listBlobs()) {

        // If the item is a blob, a virtual directory.
        if (blobItem instanceof CloudBlobDirectory) {

            CloudBlobDirectory blobDir = (CloudBlobDirectory) blobItem;
            downloadDirectory(blobDir);
        }
    }
}

public static void downloadDirectory(CloudBlobDirectory blobDir)
        throws IOException, StorageException, URISyntaxException {

    Files.createDirectories(Paths.get(destFilePath + blobDir.getPrefix()));

    for (ListBlobItem blobInDir : blobDir.listBlobs()) {

        if (blobInDir instanceof CloudBlockBlob) {
            CloudBlockBlob blob = (CloudBlockBlob) blobInDir;
            blob.downloadToFile(destFilePath + blob.getName());
        } else {
            downloadDirectory((CloudBlobDirectory) blobInDir);
        }
    }

}