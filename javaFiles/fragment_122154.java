final String json = 
given().
        param("param1", 2014).
        param("param2", "something").
        param("list", "item1", "item2").
when().
        get("/search").
then().
       statusCode(200).
extract().
          body().asString();