public void gss() throws Exception{
    MongoClient mongo = new MongoClient("192.168.1.1");
    DB db = mongo.getDB("test");
    DBCollection collection = db.getCollection("stackoverflow");
    DBObject o1 = new BasicDBObject();
    o1.put("s_mac", "AA:AA:AA:AA:AA:AA");
    o1.put("_cls", "Sample1");
    DBObject o2 = new BasicDBObject();
    o2.put("s_mac", "90:27:E4:0E:3D:D2");
    o2.put("_cls", "Sample2");
    DBObject o3 = new BasicDBObject();
    o3.put("s_mac", "A8:26:D9:E6:1D:8B");
    o3.put("_cls", "Sample3");
    collection.insert(o1, o2, o3);
    System.out.println(collection.find().count());
    List<String> MAC_LIST = Arrays.asList("90:27:E4:0E:3D:D2", "A8:26:D9:E6:1D:8B");
    System.out.println(collection.find(new BasicDBObject("s_mac", new BasicDBObject("$in", MAC_LIST))).count());
}