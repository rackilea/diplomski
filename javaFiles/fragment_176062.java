// findAndModify operation. Update colour to blue for cars having speed < 45
    DBObject query = new BasicDBObject("speed",
            new BasicDBObject("$lt", 45));
    DBObject update = new BasicDBObject();
    update.put("$set", new BasicDBObject("color", "Blue"));
    DBCursor cursor = coll.find();
    try {
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    } finally {
        cursor.close();
    }
    coll.findAndModify(query, update);