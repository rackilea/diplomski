DBCursor cursor = coll.find();
    BasicDBObject query = new BasicDBObject("NodeName", name);

    cursor = coll.find(query);
    try {
        while (cursor.hasNext()) {

            //System.out.println(cursor.next());
            DBObject tobj = cursor.next();
            System.out.println(tobj);
            details[0] = (String) tobj.get("NodeName");
            details[1] = (String) tobj.get("FirstName");
            details[2] = (String) tobj.get("LastName");

            System.out.println("in details ");
            for (int i = 0; i < details.length; i++) {
                System.out.println("in details " + details[i]);
            }
        }
    } finally {
        cursor.close();
    }
    mongoClient.close();
} catch (UnknownHostException e) {
    e.printStackTrace();
}