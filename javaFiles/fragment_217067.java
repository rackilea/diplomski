String[] urls = new String[] {"http://example1.com", "http://example2.com"};
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (String url : urls) {
         builder.add(
             Json.createObjectBuilder().add("URL", url)
         );
    }
    final JsonObjectBuilder json = Json.createObjectBuilder();
    json.add("URLs", builder.build())
        .add("Total_Size", "12345");

    JsonObject out = json.build();