DBCollection coll = // Define your collection here

DBObject query = new BasicDBObject();
query.put("user", "me");

DBObject updateObj = new BasicDBObject();
updateObj.put("aStruct.subfield_1", false);

coll.updateMulti(query, new BasicDBObject("$set", updateObj));