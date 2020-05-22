Aggregation aggregation = newAggregation(
        match(Criteria.where("_id").is(1)),
        project( "_id", "sensorName", "samplePeriod").and(new AggregationExpression() {
            @Override
            public DBObject toDbObject(AggregationOperationContext aggregationOperationContext) {
                DBObject filter = new BasicDBObject("input", "$data").append("as", "result").append("cond",
                        new BasicDBObject("$and", Arrays.<Object> asList(new BasicDBObject("$gte", Arrays.<Object> asList("$$result.timestamp", 1483537204000L)),
                                new BasicDBObject("$lte", Arrays.<Object> asList("$$result.timestamp", 1483537214000L)))));
                return new BasicDBObject("$filter", filter);
            }
        }).as("data")
);

List<BasicDBObject> dbObjects = monoTemplate.aggregate(aggregation, "collectionname", BasicDBObject.class).getMappedResults();