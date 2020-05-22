AggregationOptions aggregationOptions = Aggregation.newAggregationOptions()
        // this is very important: if you do not set the batch size, you'll get all the objects at once and you might run out of memory if the returning data set is too large
        .cursorBatchSize(mongoCursorBatchSize)
        .build();

    data = mongoTemplate.aggregateStream(Aggregation.newAggregation(
            Aggregation.group("person_id").count().as("count")).withOptions(aggregationOptions), collectionName, YourClazz.class);