//1. Convert Java object to JSON format
 ObjectMapper mapper = new ObjectMapper();
 mapper.writeValue(new File("c:\\user.json"), user);

 //2. Convert JSON to Java object
 ObjectMapper mapper = new ObjectMapper();
 User user = mapper.readValue(new File("c:\\user.json"), User.class);