ObjectId id= new ObjectId("4f693d40e4b04cde19f17205");        
BasicDBObject searchQuery = new BasicDBObject();        
searchQuery .put("_id", id); 

BasicDBObject updateDocument = new BasicDBObject();
updateDocument .append("$set", new BasicDBObject("username", username1));

coll.update(searchQuery , updateDocument);