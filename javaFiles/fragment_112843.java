// Define the search query
BasicDBObject searchQuery = new BasicDBObject().append("idU", idUser);

// To create the json query to modify
BasicDBObject logDocument = new BasicDBObject();

// Create the object and add it to a list (because the $each require a list)
List<DBObject> list = new ArrayList<DBObject>();
DBObject object = new BasicDBObject().append("text", logMessage.getText());
object.append("level", logMessage.getLevel())
object.append("date", logMessage.getDate());
list.add(object);

// Create the $sort and $slice query at the same time
logDocument.append(
    "$push",
    new BasicDBObject().append("logs", new BasicDBObject().append("$each", list).append("$sort", new BasicDBObject().append("date", 1))
            .append("$slice", -10)));

String json = "{findAndModify:\"collectionLog\", query:" + searchQuery.toString() + ", update: " + logDocument.toString() + ", upsert:true}";

try {
     getMongoTemplate().executeCommand(json);
} catch (Exception e) {
     System.out.println(e);
}