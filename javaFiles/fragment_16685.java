class MyController {
  private final JPAApi jpa;
  @Inject
  public MyController(JPAApi jpa) {
    this.jpa = jpa;
  }

  public myAction() {
    ObjectNode result = Json.newObject();
    try {
      JsonNode json = request().body().asJson();

      // Calls someFunction inside a transaction.
      // If there's an exception, rolls back transaction
      // and rethrows.
      jpa.withTransaction(() -> someFunction(json));

      // Transaction has been committed.
      result.put("success", true);
      return ok(Json.toJson(result));
    } catch(Exception e) {
      // Transaction has been rolled back.
      result.put("success", false);
      result.put("msg", e.getMessage());
      return internalServerError(Json.toJson(result));
    }
  }
}