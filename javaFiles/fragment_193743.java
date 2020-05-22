MongoClient client = new MongoClient(new ServerAddress("127.0.0.1", 27017));

    DB test = client.getDB("test");

    DBCollection sample = test.getCollection("sample");

    List<DBObject> aggregationQuery = Arrays.<DBObject>asList(
            new BasicDBObject("$sort",new BasicDBObject("score",-1)),
            new BasicDBObject("$limit",1)
    );

    System.out.println(aggregationQuery);

    Cursor aggregateOutput = sample.aggregate(
            aggregationQuery,
            AggregationOptions.builder()
                    .allowDiskUse(true)
                    .build()
    );

    while ( aggregateOutput.hasNext() ) {
        DBObject doc = aggregateOutput.next();
        System.out.println(doc);
    }