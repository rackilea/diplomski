public JsonObject config() {
  JsonObject json = Vertx.currentContext().config();
  if (json == null) {
    return new JsonObject(
      vertx.fileSystem()
        .readFileBlocking("Your-Hard-Coded-Fallback.json"));
  }
  return json;
}