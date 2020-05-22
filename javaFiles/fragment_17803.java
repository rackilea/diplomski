Aggregation agg = newAggregation(
    project("id").andExpression("month(createdDate)").as("month_joined"),
    group("month_joined").count().as("number"),
    project("number").and("month_joined").previousOperation(),
    sort(ASC, "number")
);

AggregationResults<JoinCount> results = mongoTemplate.aggregate(agg, 
                                                     "collectionName", JoinCount.class);
List<JoinCount> joinCount = results.getMappedResults();