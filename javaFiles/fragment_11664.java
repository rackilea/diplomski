DBObject nameIndex = new BasicDBObject();
nameIndex.put("name",1);

DBObject nameIndexOptions = new BasicDBObject();
nameIndexOptions.put("unique", true);

queue.ensureIndex(nameIndex, nameIndexOptions);