Response response = 
given().
       header("authToken",userToken).
when().
       get("/students").
then().
       contentType(ContentType.JSON).
extract().
       response(); 
int sizeOfList = response.body().path("list.size()");