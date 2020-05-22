DBObject query = new BasicDBObject("item", "060478132");
DBObject document = collection.findOne(query, new BasicDBObject("some_id", 1);
if (document != null) {
    DBObject someId = document.get("some_id");
    if (someId != null) {
        DBObject result = someId.get("5");
    }
}