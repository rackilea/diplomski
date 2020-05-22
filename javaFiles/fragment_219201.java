String id = "7875a7a1";
given().
       ...          
when().
       post("/x").
then().
       body("links.a.find { it.@id == '%s'}.attributes().any { it.key == 'title' }", withArgs(id), is(true));