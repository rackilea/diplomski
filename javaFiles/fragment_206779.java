AggregationOperation addFields = new AggregationOperation() {
    @Override
    public DBObject toDBObject(AggregationOperationContext aggregationOperationContext) {
        DBObject dbObject =
                new BasicDBObject("courses",
                        new BasicDBObject("$filter",
                                new BasicDBObject("input", "$$courses").
                                        append("as", "course").
                                        append("cond",
                                            new BasicDBObject("$eq", Arrays.<Object>asList("$$course._id", new ObjectId("58d65541495c851c1703c57f"))))));
        return new BasicDBObject("$addFields", dbObject);
    }
};

Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("_id").is(new ObjectId("58e8da206ca4f710bab6ef74"))),
            addFields
 );