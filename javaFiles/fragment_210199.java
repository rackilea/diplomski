public static void main(String[] args) throws Exception {
    String token = getToken();
    StorageCredentialsToken credentialsToken = new StorageCredentialsToken("storagetest789", token);
    CloudBlobClient blobClient = new CloudBlobClient(new URI("https://storagetest789.blob.core.windows.net/"), credentialsToken);
    CloudBlobContainer blobContainer = blobClient.getContainerReference("pub");
    CloudBlockBlob blockBlob = blobContainer.getBlockBlobReference("test1.txt");
    blockBlob.uploadText("mytest");
}