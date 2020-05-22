JsonArray value = Json.createArrayBuilder()
     .add(Json.createObjectBuilder()
         .add("type", "home")
         .add("number", "212 555-1234"))
     .add(Json.createObjectBuilder()
         .add("type", "fax")
         .add("number", "646 555-4567"))
     .build();