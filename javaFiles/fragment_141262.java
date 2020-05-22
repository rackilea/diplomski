Document myDoc;   
    BasicDBObject query = new BasicDBObject();
    query.put("fbid", "1");
    myDoc = fb_users.find(query).first();
    int postId=5;
    int rating=3;
    Document listItem = new Document("ratings", new   Document(String.valueOf(rating), String.valueOf(postId)));
    Document updateQuery = new Document("$push", listItem);
    fb_users.updateOne(myDoc, updateQuery);
    MongoCursor<Document> curs = fb_users.find(query).iterator();
    ArrayList<Document> list  = (ArrayList<Document>) myDoc.get("ratings");
    Iterator<Document> iterateList = list  .iterator();
    while(iterateList .hasNext()){
        Document pair = iterateList .next();
        for(String element : pair.keySet()){
            System.out.println(element + " " + pair.get(element));
        }
    }