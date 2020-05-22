Aggregation aggregation = newAggregation(
    // Using the match helper for the `$match` stage
    match(
        Criteria.where("age").gte(20).lte(50)
    ),
    // Mixed in with custom classes for the others
    new CustomAggregationOperation(
        new BasicDBObject("$sample", new BasicDBObject("size",100))
    ),
    new CustomAggregationOperation(
        new BasicDBObject(
            "$group",
            new BasicDBObject("_id",null)
                .append("ageStdDev",new BasicDBObject("$stdDevSamp","$age"))
        )
    )
);