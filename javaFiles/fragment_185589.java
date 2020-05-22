AggregationOperation redactOperation = aggregationOperationContext -> {
    Map<String, Object> map = new LinkedHashMap<>();
    BasicDBObject cmp =  new BasicDBObject("$cmp", Arrays.asList( "$items.address","$dist.location"));
    map.put("if", new BasicDBObject("$eq", Arrays.asList(cmp, 0)));
    map.put("then", "$$KEEP");
    map.put("else", "$$PRUNE");
    return new BasicDBObject("$redact", new BasicDBObject("$cond", map));
};

Aggregation agg = Aggregation.newAggregation(
    Aggregation.geoNear(nearQuery, "calculated"), 
    Aggregation.unwind("items"),
    redactOperation,
    Aggregation.skip(skip), 
    Aggregation.limit(limit)
);