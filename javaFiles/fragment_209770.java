BasicDBObject query = new BasicDBObject(
    "messages",
    new BasicDBObject(
        "$elemMatch",
        new BasicDBObject( "source", 1 )
            .append( new BasicDBObject(
               "date",
               new BasicDBObject( "$gte", StartDate )
                   .append( "$lt", EndDate )
            )
        )
    )
);