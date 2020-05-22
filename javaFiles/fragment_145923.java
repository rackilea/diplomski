Mongo mongo = new Mongo("localhost", 27017);
DB db = mongo.getDB("test");// Use DB 
DBObject allQuery = new BasicDBObject(); 
DBCollection collection = db.getCollection("dimensions"); 
DBCursor curs = collection.find(); 
Iterator<DBObject> fields = curs.iterator(); 
while(fields.hasNext()){ //
   BasicDBList geoList = (BasicDBList) fields.next().get("GeoLevels");
   BasicDBObject object = (BasicDBObject) geoList.get(0); // this should return {"5": "Continent_Name"}
   Object value = object.get("5); // value should contain "Continent_Name"
}