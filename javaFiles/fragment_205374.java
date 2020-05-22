Map<Object,Object> map= new HashMap<Object,Object>();
DBCollection collection = database.getCollection("Members");
BasicDBObject query = new BasicDBObject();
query.put("id", new BasicDBObject("$in", new Integer[] {3, 7}));
DBCursor cursor = collection.find(query);
DBObject one;
while(cursor.hasNext()) {
    one = cursor.next();
    map.put(one.get("id"),one.get("name"));
}