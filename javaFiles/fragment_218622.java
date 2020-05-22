MongoClient client= new MongoClient();
MongoDatabase db = client.getDatabase("dbname");
MongoCollection col = db.getCollection("dbcollection");

List<String> topics = new ArrayList<String>();
topics.add("Business");
topics.add("Technology");
topics.add("Sports");
topics.add("Career");

col.findOneAndUpdate(Filters.eq("_id", new ObjectId("58b1404d002d2b1a481b8ddf")), Updates.pushEach("readAbout", topics));