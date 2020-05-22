List<string> values = new ArrayList<string>();
values.add("val1")
values.add("val2")
BasicDBObject query = new BasicDBObject();
query.put("key", new BasicDBObject("$in", values));
DBCursor cursor = yourcollection.find(query);