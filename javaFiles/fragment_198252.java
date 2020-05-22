DBObject elemMatch = new BasicDBObject();
elemMatch.put("lastName","Smith");
elemMatch.put("firstName","John");

DBObject query = new BasicDBObject();
query.append( "type", "AB");
query.append( "list", elemMatch);