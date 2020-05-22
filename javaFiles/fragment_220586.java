String connectStr = "storage account connection";

        // Create a BlobServiceClient object which will be used to create a container client
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("container name");

        BlobClient blobClient=containerClient.getBlobClient("blob name");

        System.out.println(blobClient.getBlobUrl());