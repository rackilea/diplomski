MongoClient mongo = new MongoClient ("localhost", 27017);
        DB db = mongo.getDB("DBHC2");
        DBCollection movieDocument = db.getCollection("movies");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("rateMovies.idMovie", idMovie);
        DBCursor cursor = movieDocument.find(searchQuery);