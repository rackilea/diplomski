List<String> list= new ArrayList();
ids.add("1");
ids.add("2");
ids.add("3)
BasicDBObject basicObject = new BasicObject("$in", list);
query.filter("id", basicObject);