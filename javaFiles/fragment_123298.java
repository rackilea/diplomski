AggregationOperation redact = new AggregationOperation() {
    @Override
    public DBObject toDBObject(AggregationOperationContext aggregationOperationContext) {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("if",  BasicDBObject.parse("{'$gte':[{'$subtract':[{'$ifNull':['$acceptedDate', {'$date':" + System.currentTimeMillis() + "}]},'$lastVisit']},1296000000]}}"));
    map.put("then", "$$KEEP");
    map.put("else", "$$PRUNE");
    return new BasicDBObject("$redact", new BasicDBObject("$cond", map));
};

Aggregation aggregation = Aggregation.newAggregation(redact);

List<FactoryAcceptance> results = mongoTemplate.aggregate(aggregation, FactoryAcceptance.class, FactoryAcceptance.class).getMappedResults();