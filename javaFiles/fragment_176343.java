// set up pipeline
List<DBObject> ops = new ArrayList<DBObject>();
ops.add(new BasicDBObject("$out", "target")); // writes to collection "target"

// run it
MongoClient client = new MongoClient("host");
DBCollection source = client.getDB("db").getCollection("source")
source.aggregate(ops);