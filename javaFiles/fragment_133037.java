Mongo m = new Mongo("localhost", 27017);
DB db = m.getDB("test");
DBCollection myColl = db.getCollection("myCollection");

BasicDBObject docToInsert = new BasicDBObject("resourceID", "3");
docToInsert.put("resourceName", "Foo Test3");

BasicDBObject updateQuery = new BasicDBObject("_id", "1");
updateQuery.put("itemList.itemID", "1");

BasicDBObject updateCommand = new BasicDBObject("$push", new BasicDBObject("itemList.$.resources", docToInsert));

myColl.update(updateQuery, updateCommand);
System.out.println(myColl.findOne().toString());