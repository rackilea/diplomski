String endpoint="<your cosmos db endpoint>";
        String key="<your key>";
        ConnectionPolicy connectionPolicy = new ConnectionPolicy();
        connectionPolicy.setMaxPoolSize(1000);
        DocumentClient client = new DocumentClient(
                endpoint,
                key,
                connectionPolicy,
                ConsistencyLevel.Session);
        String databaseId="testbulk";
        String collectionId="items";
        String databaseLink = String.format("/dbs/%s", databaseId);
        String collectionLink = String.format("/dbs/%s/colls/%s", "testbulk", collectionId);

        ResourceResponse<Database> databaseResponse = null;
        Database readDatabase = null;
        try {
            databaseResponse = client.readDatabase(databaseLink, null);
            readDatabase = databaseResponse.getResource();

            System.out.println("Database already exists...");

        } catch (DocumentClientException dce) {
            if (dce.getStatusCode() == 404) {
                System.out.println("Attempting to create database since non-existent...");

                Database databaseDefinition = new Database();
                databaseDefinition.setId(databaseId);


                    client.createDatabase(databaseDefinition, null);


                databaseResponse = client.readDatabase(databaseLink, null);
                readDatabase = databaseResponse.getResource();
            } else {
                throw dce;
            }
        }

        ResourceResponse<DocumentCollection> collectionResponse = null;
        DocumentCollection readCollection = null;

        try {
            collectionResponse = client.readCollection(collectionLink, null);
            readCollection = collectionResponse.getResource();

            System.out.println("Collection already exists...");
        } catch (DocumentClientException dce) {
            if (dce.getStatusCode() == 404) {
                System.out.println("Attempting to create collection since non-existent...");

                DocumentCollection collectionDefinition = new DocumentCollection();
                collectionDefinition.setId(collectionId);

                PartitionKeyDefinition partitionKeyDefinition = new PartitionKeyDefinition();
                Collection<String> paths = new ArrayList<String>();
                paths.add("/id");
                partitionKeyDefinition.setPaths(paths);
                collectionDefinition.setPartitionKey(partitionKeyDefinition);

                RequestOptions options = new RequestOptions();
                options.setOfferThroughput(1000000);

                // create a collection
                client.createCollection(databaseLink, collectionDefinition, options);

                collectionResponse = client.readCollection(collectionLink, null);
                readCollection = collectionResponse.getResource();
            } else {
                throw dce;
            }
        }

        System.out.println(readCollection.getId());
        System.out.println(readDatabase.getId());

        ArrayList<String> list = new ArrayList<String>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("e:\\test.json")) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray jsonArray  = (JSONArray) obj;
            System.out.println(jsonArray);
            // cast jsonarry to string list
            if (jsonArray  != null) {
                int len = jsonArray.size();
                for (int i=0;i<len;i++){
                    list.add(jsonArray.get(i).toString());
                }
            }
            System.out.println(list.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Set client's retry options high for initialization
        client.getConnectionPolicy().getRetryOptions().setMaxRetryWaitTimeInSeconds(30);
        client.getConnectionPolicy().getRetryOptions().setMaxRetryAttemptsOnThrottledRequests(9);

       // Builder pattern
        DocumentBulkExecutor.Builder bulkExecutorBuilder = DocumentBulkExecutor.builder().from(
                client,
                databaseId,
                collectionId,
                readCollection.getPartitionKey(),
                20000) ;// throughput you want to allocate for bulk import out of the container's total throughput

         // Instantiate DocumentBulkExecutor
        try {
            DocumentBulkExecutor bulkExecutor = bulkExecutorBuilder.build();
            // Set retries to 0 to pass complete control to bulk executor
            client.getConnectionPolicy().getRetryOptions().setMaxRetryWaitTimeInSeconds(0);
            client.getConnectionPolicy().getRetryOptions().setMaxRetryAttemptsOnThrottledRequests(0);
            BulkImportResponse bulkImportResponse = bulkExecutor.importAll(list, false, false, null);
            System.out.println(bulkImportResponse.getNumberOfDocumentsImported());
        } catch (Exception e) {
            e.printStackTrace();
        }