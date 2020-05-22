Aggregation aggregation = newAggregation(
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