Mongo mongo = new Mongo("localhost:27017");
        DB db = mongo.getDB("myDB");
        DBCollection coll = db.getCollection("myCollection");

        DBObject statusQuery = new BasicDBObject("status", true);
        DBObject elemMatchQuery = new BasicDBObject("$elemMatch", statusQuery);

        DBObject fields = new BasicDBObject();
        fields.put("items", elemMatchQuery);
        fields.put("name", 1);
        fields.put("config", 1);

        DBCursor cur = coll.find(new BasicDBObject(), fields);

        while (cur.hasNext()) {
            DBObject obj = cur.next();
            // Get fields from object
        }