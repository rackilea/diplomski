ObjectMapper mapper = new ObjectMapper();
InputStream stream = new FileInputStream("c:\\user.json");
User user;

JsonNode json = mapper.readTree(stream);

//NOTE: calling json.isArray() should return true.
for (JsonNode userJson : json)
{
  user = mapper.readValue(userJson, User.class);
  // use the constructed user...
}