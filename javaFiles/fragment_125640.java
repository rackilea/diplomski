AggregateIterable<Document> findIterable = tripsCollection.aggregate(
     Arrays.asList(
      new Document("$match", new Document("busId", busId)),
      new Document("$unwind", "$location"),
      new Document("$sort", new Document("location.position", -1)),
      new Document("$group", 
           new Document("_id", "$_id")
            .append("driverId", new Document("$first","$driverId"))
            .append("busId", new Document("$first","$busId"))
            .append("startTime", new Document("$first","$startTime"))
            .append("location", new Document("$push","$location"))
      ),
      new Document("$sort", new Document("startTime", -1))
   )
);