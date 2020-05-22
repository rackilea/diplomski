DBObject query = QueryBuilder.start()
                         .put("_id.r").is("15500304")
                         .put("_id.eT").is(date)
                         .put("v").is(169000)
                         .get();

DBCursor cursor = collection.find(query);
while(cursor.hasNext()){
    System.out.println(cursor.next());
}