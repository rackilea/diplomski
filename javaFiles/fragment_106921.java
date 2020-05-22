RequestOptions requestOptions = new RequestOptions();
 requestOptions.setOfferThroughput(400);
 PartitionKey partitionKey = new PartitionKey("jay");
 requestOptions.setPartitionKey(partitionKey);

        client.deleteDocument("/dbs/"+databaseName+"/colls/"+collectionName+"/docs/1",requestOptions);