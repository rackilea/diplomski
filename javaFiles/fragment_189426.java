BasicDBObject query = BasicDBObject("status", 
    new BasicDBObject("$in", Arrays.asList("a", "b", "c"))
)
    .append("flightDetails.0",
      new BasicDBObject("$exists",true)
    );