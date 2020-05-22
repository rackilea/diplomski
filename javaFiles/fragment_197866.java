AggregateIterable<Document> result = chatLogCollection.aggregate(Arrays.asList(
                new Document("$group", new Document("_id", "$sessionGUID")
                        .append("time", new Document("$first", "$ts"))
                        .append("makerID", new Document("$first","$makerID"))),
                new Document("$sort", new Document("time", -1)),
                new Document("$skip", skip),
                new Document("$limit", limit)
        ));