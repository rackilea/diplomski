MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

DB db = mongoClient.getDB( "test" );
DBCollection coll = db.getCollection("mycol");
List<String> tags = new ArrayList<String>();
tags.add("Demo");
tags.add("MongoDB");
tags.add("Java");
BasicDBObject doc = new BasicDBObject("title", "MongoDB").
        append("tags", tags);
coll.insert(doc);