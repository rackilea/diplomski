BasicDBObject query = new BasicDBObject("_id", new ObjectId("50656f33a4e82d3f98291eff"));

BasicDBObject docToRemove = new BasicDBObject("name", "gdfgdfgdfg");

BasicDBObject updateCommand = new BasicDBObject("$pull", new BasicDBObject("menus", docToRemove));

collection.update(query, updateCommand);