Mongo mongo = new Mongo("localhost", 27017);
 DB db = mongo.getDB("dbName");
 DBCollection collection = db.getCollection("collectionName");
 List distinctCity = collection.distinct("cityname");
 for(int i = 0; i < distinctCity.size(); i++) {
   BasicDBObject query = new BasicDBObject();
   query.put("cityname", distinctCity.get(i));
   BasicDBObject project = new BasicDBObject();
   project.put("JAN", 1);
   project.put("_id", 0);
   DBCursor cursorDoc = collection.find(query, project);
   while(cursorDoc.hasNext()) {
     BasicDBObject object = (BasicDBObject) cursorDoc.next();
     Integer currentValue = object.getInt("JAN");
     DBCursor allData = collection.find(new BasicDBObject(), project);
     while(allData.hasNext()) {
       BasicDBObject allDataObject = (BasicDBObject) allData.next();
       Integer allDataJanValue = allDataObject.getInt("JAN");
       Integer result = currentValue - allDataJanValue;
       System.out.print("  " + result + "  ");
     }
     System.out.println();
   }
 }
 }