final Aggregation aggregation = newAggregation(
    Aggregation.sort(Sort.Direction.DESC, "date"),
    Aggregation.group("userId").first("date").as("Date")
);

final AggregationResults<User> results = mongoTemplate.aggregate(aggregation, "user", User.class);