RestAssured.baseURI = "https://servicenowAPIadd.com";
RestAssured
    .given()
    .urlEncodingEnabled(true)               //Encoding should be enabled by default anyway
    .queryParam("sysparm_display_value", "true")
    .queryParam("sysparm_query", "col_updated_on>=2017-09-30")
    .when()
    .get("/api/now/table/" + tableName);