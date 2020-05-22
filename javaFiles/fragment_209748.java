BasicDBObject dbo = new BasicDBObject();
    dbo.put("name", "first");
    collection.insert(dbo);

    dbo.put("_id", null);
    dbo.put("name", "second");
    dbo.put("otherInfo", new BasicDBObject("text", "sometext"));
    collection.insert(dbo);

    DBObject query = new BasicDBObject("otherInfo.text", new BasicDBObject("$exists", true));
    DBCursor result = collection.find(query);
    System.out.println(result.size());
    System.out.println(result.iterator().next());