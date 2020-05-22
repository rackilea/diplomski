// getCollection

    DBCollection myColl = db.getCollection("toskebre");

    // for the $group operator
    // note - the collection still has the field name "dolaznaStr"
    // but, to we access "dolaznaStr" in the aggregation command, 
    // we add a $ sign in the BasicDBObject 

    DBObject groupFields = new BasicDBObject( "_id", "$dolaznaStr");

    // we use the $sum operator to increment the "count" 
    // for each unique dolaznaStr 
    groupFields.put("count", new BasicDBObject( "$sum", 1));
    DBObject group = new BasicDBObject("$group", groupFields );


    // You can add a sort to order by count descending

    DBObject sortFields = new BasicDBObject("count", -1);
    DBObject sort = new BasicDBObject("$sort", sortFields );


    AggregationOutput output = myColl.aggregate(group, sort);

    System.out.println( output.getCommandResult() );