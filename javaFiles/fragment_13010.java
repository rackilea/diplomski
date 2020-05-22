@FunctionName("addentity")
    public String addentity(@HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) String req,
                            ExecutionContext context) {

        String storageConnectionString =
                "***";
        String jsonStr = "insert failed";

        try {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount =
                    CloudStorageAccount.parse(storageConnectionString);

            // Create the table client.
            CloudTableClient tableClient =
                    storageAccount.createCloudTableClient();

            // Create a cloud table object for the table.
            CloudTable cloudTable = tableClient.getTableReference("test");

            // Create a new customer entity.
            myEntity entity = new myEntity("jay1","gong");
            //entity.setProp1("a");
            entity.setNewProp("new");
            entity.setOldProp("old");
            //entity.setNewProp1("new1");
            //entity.setName("kkkkk");

            // Create an operation to add the new customer to the people table.
            TableOperation insertEntity =
                    TableOperation.insert(entity);

            // Submit the operation to the table service.
            cloudTable.execute(insertEntity);

            jsonStr = entity.toString();

        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }


        return jsonStr;
    }