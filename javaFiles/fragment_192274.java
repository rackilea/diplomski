given()
        .log().ifValidationFails()
        .pathParam("reqID", "123")
.when()
        .get("request/{reqID}")
.then()
        .log().ifValidationFails()
        .statusCode(200);