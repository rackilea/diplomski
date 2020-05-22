LookupOperation lookupOperation = LookupOperation.newLookup()
    .from("places")
    .localField("address.location.place._id")
    .foreignField("_id")
    .as("address.location.place");

Aggregation agg = newAggregation(
    unwind("address"),
    unwind("address.location"),
    lookupOperation  
);

AggregationResults<OutputDocument> aggResults = mongoTemplate.aggregate(
    agg, PersonAddressDocument.class, OutputDocument.class
);