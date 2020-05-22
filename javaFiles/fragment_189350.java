public Future<JsonObject> save() {
    Future<JsonObject> future = Future.future();
    MongoDBConnection.mongoClient.save("booking", query, res -> {
      if(res.succeeded()) {
        documentID = res.result();
        if(documentID != null) {
          System.out.println("MongoDB inserted successfully. + document ID is : " + documentID);
          String resMsg = "A confirmed booking has been successfully created with booking id as " + documentID +
            ". An email has also been triggered to the shared email id " + emailID;
          future.complete(new JsonObject().put("fulfillmentText", resMsg));
        }else{
          future.complete(new JsonObject().put("fulfillmentText",
            "There is some issues while booking the shipment. Please start afreash."))
        }
      } else {
        System.out.println("MongoDB insertion failed.");
        future.fail(res.cause());
      }
    });
    return future;
  }