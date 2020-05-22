DBCollection collection = mongoClient.getDB("stackoverflow").getCollection("demo");

BasicDBObject filter = new BasicDBObject();
BasicDBObject projection = new BasicDBObject();

// project on "Project_Information.Project_Description"
projection.put("Project_Information.Project_Description", 1);

DBCursor documents = collection.find(filter, projection);

for (DBObject document : documents) {
    // the response contains a sub document under the key: "Project_Information"
    DBObject projectInformation = (DBObject) document.get("Project_Information");
    // the "Project_Description" is in this sub document
    String projectDescription = (String) projectInformation.get("Project_Description");

    // prints "Sample"
    System.out.println(projectDescription);

    // to return this single String value in an Object[] (as implied by your OP) just do create the Object[] like this and then return it ...
    Object[] r = new Object[] {projectDescription};

    // prints the entire projected document e.g. 
    // { "_id" : { "$oid" : "59db2321811a592384865711" }, "Project_Information" : { "Project_Description" : "Sample" } }
    System.out.println(document.toString());
}