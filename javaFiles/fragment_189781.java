@Override
public List<Object> getDistinctValues(String collection, String fieldName, Sort.Direction sort) {
    Aggregation agg = Aggregation.newAggregation(
            Aggregation.group(fieldName),
            Aggregation.sort(sort, "_id")
    );
    return mongoTemplate.aggregate(agg, collection, Document.class)
            .getMappedResults()
            .stream()
            .map(item -> item.get("_id"))
            .collect(Collectors.toList());
}