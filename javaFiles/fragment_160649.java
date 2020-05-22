// ...
JsonObject selectQuery /* the query initialization goes here */;
// ...
vertx.eventBus().send(
  "database.mysql", 
  selectQuery, 
  new Handler<Message<JsonObject>>() {
    public void handle(Message<JsonObject> result) {
      String results = result.body().getArray("results").toString();
      String arrs[]=results.split(",");
      System.out.println("I received a reply before the timeout of 5 seconds"+arrs[1]);
      res = arrs[1];
      if(res.equals("true")) {
        deployVerticles(); // Triggering verticle deployment goes within your response handler
      }
    }
  }
);