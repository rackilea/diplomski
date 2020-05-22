String id = "7875a7a1";
given().
       ...          
when().
       post("/x").
then().
       body("links.a.find { it.@id == '%s'}.@title", withArgs(id), equalTo("doctor"));