BasicDBList list = new BasicDBList();
list.add("Mick Jagger");
list.add("Bob Dyla");
list.add("Tony Orlando");

QueryBuilder qb = new QueryBuilder();
qb.put("person_name").in(list);