BasicDBObject query = BasicDBObject("status", 
    new BasicDBObject("$in", Arrays.asList("a", "b", "c"))
)
    .append("$or",Arrays.<Object>asList(
        new BasicDBObject("flightDetails.0",
            new BasicDBObject("$exists",true)
        ),
        new BasicDBObject("flightDetails",
            new BasicDBObject("$exists",false)
        )
    ));