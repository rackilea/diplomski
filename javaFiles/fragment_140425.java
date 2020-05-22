// id of the document
Document id = new Document("key", 1);

// array of documents
List<Document> docArray = Arrays.asList(
    new Document("key1", "val1"),
    new Document("key2", "val2"));

// insert the new document
Document doc = new Document("key", 1).append("docarray", docArray);
collection.insertOne(doc);
System.out.println("Before: " + collection.find(id).first().toJson());

// new array of documents
List<Document> docArrayUpdated = Arrays.asList(
    new Document("key3", "val3"),
    new Document("key4", "val4"));

// update the document with the new array
collection.updateOne(id, Updates.set("docarray", docArrayUpdated));
System.out.println("After: " + collection.find(id).first().toJson());