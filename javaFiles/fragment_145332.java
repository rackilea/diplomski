/**
* Checks if an activity exists with a given id. if no such activity exists
* returns false. Returns true for one or more activities with a matching
* id.
* 
* @param db
* @param id
* @return boolean - true if one or more functions with matching names exit.
*/
public static boolean activityExists(MongoDatabase db, ObjectId id) {
    FindIterable<Document> iterable = db.getCollection("activity").find(new Document("_id", id));
    return iterable.first() != null;
}