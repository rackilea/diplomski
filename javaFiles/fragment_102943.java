MongoClient mongoClient = null;
DBCursor cursor = null;
try {
    mongoClient = new MongoClient( "localhost" , 27017 );
    DB db = mongoClient.getDB( "swingtest" );
    DBCollection coll = db.getCollection("table");
    cursor = coll.find();

    String[] columnNames = {"id", "First", "Last"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    while(cursor.hasNext()) {
        DBObject obj = cursor.next();
        String first = (String)obj.get("first");
        String last = (String)obj.get("last");
        ObjectId id = (ObjectId)obj.get("_id");
        model.addRow(new Object[] { id, first, last });
    }
    table.setModel(model);

    cursor.close(); 
    mongoClient.close();
}