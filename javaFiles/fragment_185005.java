DB database = mongoClient.getDB("employee_service");
DBCollection collectionProject = database.getCollection("project");
DBObject projectMongoObject = new BasicDBObject();
projectMongoObject.put("company_id", 1);
//add this
projectMongoObject.put("employee_id_list", 
        new BasicDBObject("$elemMatch", 
        new BasicDBObject("date_end", 
        new BasicDBObject("$exits", false))));
DBCuresor cursorProject = collectionProject.find(projectMongoObject);