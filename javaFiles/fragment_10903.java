package com.fabrikam.functions;

import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.ExecutionContext;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

/**
 * Hello function with HTTP Trigger.
 */
public class Function {

    // Configure the connection-string with your values
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=***;" +
                    "AccountKey=***";

    @FunctionName("hello")
    public String hello(@HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) String req,
                        ExecutionContext context) {

        try {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Get a reference to a container.
            // The container name must be lower case
            CloudBlobContainer container = blobClient.getContainerReference(req);

            // Create the container if it does not exist.
            container.createIfNotExists();

            return String.format("Hello, I get container name : %s!", container.getName());

        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
            return "Access Error!";
        }
    }
}