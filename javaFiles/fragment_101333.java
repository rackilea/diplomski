@Test
public void writeFile(){

    try {
        CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
        CloudFileClient fileClient = storageAccount.createCloudFileClient();

        CloudFileShare share=fileClient.getShareReference("storagefileshare");

        CloudFileDirectory rootDir = share.getRootDirectoryReference();

        File sourceFile = File.createTempFile("sampleFile", ".txt");
        System.out.println("Creating a sample file at: " + sourceFile.toString());
        Writer output = new BufferedWriter(new FileWriter(sourceFile));
        output.write("Hello Azure!");
        output.close();

        CloudFile cloudFile=rootDir.getFileReference(sourceFile.getName());
        cloudFile.uploadFromFile(sourceFile.getAbsolutePath());

    } catch (URISyntaxException e) {
        e.printStackTrace();
    } catch (InvalidKeyException e) {
        e.printStackTrace();
    } catch (StorageException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}