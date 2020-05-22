RequestOptions requestOptions = new RequestOptions();
 requestOptions.setOfferThroughput(400);
 PartitionKey partitionKey = new PartitionKey(Undefined.Value());
 requestOptions.setPartitionKey(partitionKey);

        client.deleteDocument("/dbs/"+databaseName+"/colls/"+collectionName+"/docs/3",requestOptions);