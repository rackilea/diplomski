given().
       header("authToken",userToken).
when().
       get("/students").
then().
       contentType(ContentType.JSON).
       body("list.size()", is(5));