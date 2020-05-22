QueryBuilder builder = QueryBuilder.start();

    builder.and("objectKey").regex(Pattern.compile("box"));
    builder.and("cache_version_string").is("08/03/15_11:05:09");

    BasicDBObject query = (BasicDBObject)builder.get();

    Bson projection = Projections.exclude(
            "_id",
            "obectdata",
            "lasModified",
            "productCode"
    );

    MongoCursor<Document> cursor = collection.find(query).projection(projection).iterator();

    while (cursor.hasNext()) {
        Document doc = cursor.next();
        System.out.println(doc.toJson());
    }