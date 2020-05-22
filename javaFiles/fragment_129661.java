BasicDBList list = new BasicDBList();
list.add("Mick Jagger");
list.add("Bob Dyla");
list.add("Tony Orlando");

DBObject query = new BasicDBObject();
query.put("person_name", new BasicDBObject("$in", list));