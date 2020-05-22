private static final String path = "D:\\upload\\";
private static final String storageConnectionString = "<your storage connection string>";
private static final String containerName = "<your container for uploading>";

private static CloudBlobClient serviceClient;

public static void upload(File file) throws InvalidKeyException, URISyntaxException, StorageException, IOException {
    // Container name must be lower case.
    CloudBlobContainer container = serviceClient.getContainerReference(containerName);
    container.createIfNotExists();
    String blobName = file.getAbsolutePath().replace(path, "");
    CloudBlockBlob blob = container.getBlockBlobReference(blobName);
    if (blob.exists() == false) {
        blob.uploadFromFile(file.getAbsolutePath());
    } else {
        System.out.println("File " + file.getAbsolutePath() + " Already exist in storage");
    }
}

public static void main(String[] args)
        throws URISyntaxException, StorageException, InvalidKeyException, IOException {
    CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
    serviceClient = account.createCloudBlobClient();
    File source = new File(path);
    for (File fileOrDir : source.listFiles()) {
        boolean isFile = fileOrDir.isFile();
        if(isFile) {
            upload(fileOrDir);
        } else {
            for(File file: fileOrDir.listFiles()) {
                upload(file);
            }
        }

    }
}