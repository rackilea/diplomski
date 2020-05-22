BasicDBObject query = new BasicDBObject();
query.put("name", Pattern.compile(","+array[i]+","));
DBCursor cursor = coll.find(query);
while(cursor.hasNext()){
   System.out.println(cursor.next().toString());
}