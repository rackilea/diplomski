FeedOptions queryOptions = new FeedOptions();
PartitionKey partitionKey = new PartitionKey("/A");
queryOptions.setPartitionKey(partitionKey);
FeedResponse<Document> feedResponse1 = client
      .queryDocuments("dbs/db/colls/part",
                    "SELECT * FROM c ", queryOptions);
System.out.println(feedResponse1.getRequestCharge());