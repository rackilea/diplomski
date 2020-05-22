FindIterable<Document> iterable3 = db.getCollection(collectionName).find(
    new Document()
        .append("timestamp", new Document()
               .append("$gte", startTime)
               .append("$lte", endTime))
        .append("hourOfDay", new Document()
                .append("$gte", minHourOfDay)
                .append("$lte", maxHourOfDay))
        .append("dayOfWeek", new Document("$in", Arrays.asList(2, 4)));
);