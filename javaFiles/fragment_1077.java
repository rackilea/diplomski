BasicDBObject searchQuery = new BasicDBObject();
DBCursor cursor = table.find(searchQuery);

while (cursor.hasNext()) {
    System.out.println(cursor.next().keySet());
}