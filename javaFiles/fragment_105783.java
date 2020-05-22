Aggregation agg = newAggregation(
    unwind("address"),
    unwind("address.location"),
    lookupOperation  
);

AggregationResults<OutputDocument> aggResults = mongoTemplate.aggregate(
    agg, PersonAddressDocument.class, OutputDocument.class
);