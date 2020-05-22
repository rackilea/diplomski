DBCollection coll = db.getCollection("students");

DBObject query = new BasicDBObject("name", "joe");

DBObject dbObj1 = new BasicDBObject();
dbObj1.put("id", 3);
dbObj1.put("score", 8);

DBObject dbObj2 = new BasicDBObject();
dbObj2.put("id", 4);
dbObj2.put("score", 7);

DBObject dbObj3 = new BasicDBObject();
dbObj3.put("id", 5);
dbObj3.put("score", 6);

BasicDBList eachList = new BasicDBList();
eachList.add(dbObj1);
eachList.add(dbObj2);
eachList.add(dbObj3);

BasicDBObject quizzesObj = new BasicDBObject();
quizzesObj.put("$each", eachList);
quizzesObj.put("$sort", new BasicDBObject("score", 1));
quizzesObj.put("$slice", -5);

coll.update(query, new BasicDBObject("$push", new BasicDBObject("quizzes", quizzesObj)));