int sizeOfList = 
given().
       header("authToken",userToken).
when().
       get("/students").
then().
       contentType(ContentType.JSON).
extract().
       path("list.size()");