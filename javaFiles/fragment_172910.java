Document query = new Document("objectKey",new Document( "$regex","Bos"))
        .append("cacheVersionString","08/03/15_11:05:09");

    Document projection = new Document("_id",0)
        .append("objectData",0)
        .append("lastModified",0)
        .append("productCode",0);

    MongoCursor<Document> cursor = collection.find(query).projection(projection).iterator();