List<Bson> aggregation = Arrays.asList(
                Aggregates.group("$searchKey", Accumulators.sum("count", 1)),
                Aggregates.sort(Sorts.descending("count")),
                Aggregates.project(Projections.fields(Projections.excludeId(), Projections.computed("searchKey", "$_id"), Projections.include("count"))));

 Iterator<Document> sortedList = collection.aggregate(aggregation).iterator();