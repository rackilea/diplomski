MongoCursor<Document> cursor = mongoCollection.find().iterator();
Document doc = cursor.next();
String id = doc.getString("_id"); // get the _id
doc.remove("_id");   // remove the _id field
IndexRequest indexRequest = new IndexRequest(indexName, indexType, id);
indexRequest.source(doc.toJson());  
BulkRequestBuilder bulkRequest = client.prepareBulk();
bulkRequest.add(indexRequest);
bulkRequest.execute().actionGet();