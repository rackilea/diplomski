final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=your storage account name;" +
                    "AccountKey=your storage connection key";
    try {
        // Use the CloudStorageAccount object to connect to your storage account
        CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

        // Create the file client.
        CloudFileClient fileClient = storageAccount.createCloudFileClient();

        // Get a reference to the file share
        CloudFileShare share = fileClient.getShareReference("windows");

        //Get a reference to the root directory for the share.
        CloudFileDirectory rootDir = share.getRootDirectoryReference();

        // Define the path to a local file.
        final String filePath = "C:\\Users\\georgec\\Documents\\test.json";

        //Get a reference to the file you want to upload
        CloudFile cloudFile = rootDir.getFileReference("test.json");
        cloudFile.uploadFromFile(filePath);
    }