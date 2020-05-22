DBCollection userCollection = db.getCollection("collection");

BasicDBObject orQuery = new BasicDBObject();
List<BasicDBObject> obj1 = new ArrayList<BasicDBObject>();
obj1.add(new BasicDBObject("a", "text"));
obj1.add(new BasicDBObject("b", "text"));
orQuery.put("$or", obj1);

BasicDBObject andQuery = new BasicDBObject();
List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
obj.add(new BasicDBObject("c", "text"));
obj.add(orQuery);
andQuery.put("$and", obj);

System.out.println(andQuery.toString());

DBCursor cursor = userCollection.find(andQuery);
while (cursor.hasNext()) {
    System.out.println(cursor.next());
}