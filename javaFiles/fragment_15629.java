@BodyParser.Of(BodyParser.Json.class)
public Result index() {
   RequestBody body = request().body();
   Data data = Json.fromJson(body.asJson(), Data.class);
   return ok("Got java object: " + data.toString());
}