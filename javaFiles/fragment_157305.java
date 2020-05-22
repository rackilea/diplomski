try {
        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("so");
        DBCollection coll = db.getCollection("employees");

        List<Integer> ageList = new ArrayList<>();
        ageList.add(30);
        ageList.add(35);

        List<String> nameList = new ArrayList<>();
        nameList.add("Anna");

        BasicDBObject query = new BasicDBObject("$and", Arrays.asList(
            new BasicDBObject("age", new BasicDBObject("$in", ageList)),
            new BasicDBObject("name", new BasicDBObject("$in", nameList)))
        );

        DBCursor cursor = coll.find(query);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
}catch (Exception ex){
        ex.printStackTrace();
}