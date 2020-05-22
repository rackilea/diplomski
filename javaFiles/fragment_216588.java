List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
writes.add(
    new UpdateOneModel<Document>(
        new Document("car", "Ferrari").append("color", "Red"), // filter
        new Document("$set", new Document("color", "Black")) // update
    )
);