BasicDBObject whereClause = new BasicDBObject();
BasicDBObject orQuery = new BasicDBObject();
BasicDBObject andQuery = new BasicDBObject();
List<BasicDBObject> objOr = new ArrayList<BasicDBObject>();
List<BasicDBObject> objAnd = new ArrayList<BasicDBObject>();

for (UserDetail userdata : req.UserDetail()) {
     List<BasicDBObject> andInsideAndQuery = new ArrayList<BasicDBObject>();
     andInsideAndQuery.add(new BasicDBObject("filed1", userdata.filed1()));
     andInsideAndQuery.add(new BasicDBObject("filed2", userdata.filed2()));
     andQuery.put("$and", andInsideAndQuery);
     objOr.add(andQuery);
}

objAnd.add(new BasicDBObject(CommonConstants.abc, 1));
orQuery.put("$or", objOr);
objAnd.add(orQuery);

whereClause.put("$and", objAnd);