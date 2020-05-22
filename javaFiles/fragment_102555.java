BasicDBObject query = new BasicDBObject("_id", 73);
    BasicDBObject fields = new BasicDBObject("goals", 
        new BasicDBObject( "goal", 4));
    BasicDBObject update = new BasicDBObject("$pull",fields);

    games.update( query, update );