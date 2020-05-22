Aggregation aggregation = Aggregation.newAggregation(
    Aggregation.match(Criteria.where("someCriteriaFlag").is(false)), 
    Aggregation.project("field1").andExclude("_id"));

List<String> fields= mongoTemplate.aggregate(aggregation, "Collection", BasicDBObject.class)
    .getMappedResults();