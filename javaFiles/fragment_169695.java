Iterable<DBObject> list= output.results();
while(list.iterator().hasNext()){
    DBObject obj = list.iterator().next();
    String id = obj.get("_id");
    int times = Integer.parseInt(obj.get("times").toString());

    System.out.println("ID IS "+id+" time: "+times);
}