User user = new User();
user.setFirstName("catherine");
user.setVersion("1.5");

ObjectMapper mapper = new ObjectMapper();
mapper.setAnnotationIntrospector(new VersioningPropertiesIntrospector(user.getVersion()));

String userJson = mapper.writeValueAsString(user);
User userRead = mapper.readValue(userJson, User.class);