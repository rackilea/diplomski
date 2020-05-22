...
DBObject selectQuery = new BasicDBObject("_id", 1); // Matches the document
selectQuery.append("Districts.name", distName); // Matches the element in the array where District name = Guntur

BasicDBObject updateFields = new BasicDBObject();
updateFields.put("Districts.$.Locations", new BasicDBObject("name":"Achampet"));

DBObject updateQuery = new BasicDBObject("$addToSet", updateFields);
statesColl.update(selectQuery, updateQuery); 
...