DBCollection collection = db.getCollection("shows");
BasicDBObject query = new BasicDBObject("_id", 1);
query.put("instances._id", new ObjectId("58cea4779f3489310471b7db"));

BasicDBObject setQuery = new BasicDBObject("$set", new BasicDBObject("instances.$.seats.0.row 1.0", 1));
collection.update(query, setQuery);