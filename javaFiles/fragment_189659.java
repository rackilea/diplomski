Aggregation agg = newAggregation(
    project()       
        .andExpression("year(timeCreated)").as("year")
        .andExpression("month(timeCreated)").as("month")
        .andExpression("dayOfMonth(timeCreated)").as("day"),
    group(fields().and("year").and("month").and("day"))     
        .sum("blabla").as("blabla")
);

AggregationResults<BlaBlaModel> result = 
    mongoTemplate.aggregate(agg, collectionName, BlaBlaModel.class);
List<BlaBlaModel> resultList = result.getMappedResults();