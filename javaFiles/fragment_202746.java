// using BasicDBObject
    collection.find().projection(new BasicDBObject("username", true)
                                 .append("lastname", true)
                                 .append("firstname", true))

    // using the new Document class
    collection.find().projection(new Document("username", true)
                                 .append("lastname", true)
                                 .append("firstname", true));

    // Using the new Projections builder
    collection.find().projection(Projections.include("username", "lastname", "firstname"));