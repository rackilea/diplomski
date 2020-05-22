Response response = SerenityRest.rest()
        .contentType("application/json")
        .when()
        .get("/api/");
if (response.statusCode() == 200) {
   int numUniqueModels = response.body().path("cars.collect { it.value.size() }.sum()");  // 9
}