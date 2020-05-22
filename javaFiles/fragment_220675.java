String mongolabUri = "mongodb://username:password@dsDATA.mongolab.com:DATA/database";
MongoClientURI uri = new MongoClientURI(mongolabUri);
MongoClient client = null;
try{
    client = new MongoClient(uri);
    DB database = client.getDB("database");
    DBCollection collection = database.getCollection("testcollections");
    DBObject document = collection.findOne();
    System.out.println(document);
}catch(UnknownHostException e){
    e.printStackTrace();                
}