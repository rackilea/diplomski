DBObject match = new BasicDBObject(
        "$match", new BasicDBObject(
            "hotelCode", "0360"
        )
    );

    DBObject sort = new BasicDBObject(
        "$sort", new BasicDBObject(
        "cofirmationNumber", -1
        ).append("timestamp", -1)
    );

    DBObject group =  new BasicDBObject(
        "$group", new BasicDBObject(
            "_id", "confirmationNumber"
        ).append(
            "timestamp", new BasicDBObject(
                "$first", "$timestamp"
            )
        ).append(
            "reservationImage", new BasicDBObject(
                "$first", "$$ROOT"
            )
        )
    );

    List<DBObject> pipeline = Arrays.asList(match,sort,group);

    DBCollection collection = mongoOperation.getCollection("collection");
    DBObject rawoutput = (DBObject)collection.aggregate(pipeline);

    List<myClass> items = new AggregationResults(List<myClass>, rawoutput).getMappedResults();