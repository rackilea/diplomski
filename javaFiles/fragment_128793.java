String myJsonString = "{\"name\":\"john\",\"lastname\":\"smith\"}";
JsonParser parser = new JsonParser();
JsonElement element = parser.parse(myJsonString); 
JsonObject jsonObject = element.getAsJsonObject();
String lastName = jsonObject.get("lastname").getAsString();
System.out.println(lastName);