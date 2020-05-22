import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

Aggregation agg = newAggregation(
    match(where("_id").is("1")), //  
    project() //
        .and("array") //
        .size() //
        .as("count")
);

AggregationResults<IntegerCount> results = mongoTemplate.aggregate(
    agg, collectionName, Integer.class
);
List<IntegerCount> intCount = results.getMappedResults();