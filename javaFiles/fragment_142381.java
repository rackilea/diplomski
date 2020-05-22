String json1 = "{ \"user\": { \"name\": \"John\", \"age\": 21, \"email\": \"john@mail.com\", \"location\": \"NYC\" }}";
    String json2 = "{ \"user\": \"John\", \"mail\": \"john@mail.com\", \"age\": \"21\" }";
    String json3 = "{ \"who\": \"John\", \"contacts\": \"john@mail.com\", \"age\": 21 }";

    ObjectMapper mapper = new ObjectMapper();
    MappingPropertyNamingStrategy namingStrategy = new MappingPropertyNamingStrategy();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    Map<String, User> res = mapper.readValue(json1, new TypeReference<Map<String, User>>() {});
    System.out.println(res.get("user"));


    mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy(namingStrategy);
    namingStrategy.setMap(new HashMap<String, String>() {{
                put("name", "user");
                put("email", "mail");
            }});
    System.out.println(mapper.readValue(json2, new TypeReference<User>(){}));


    mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy(namingStrategy);
    namingStrategy.setMap(new HashMap<String, String>() {{
                put("name", "who");
                put("email", "contacts");
            }});

    System.out.println(mapper.readValue(json3, new TypeReference<User>(){}));