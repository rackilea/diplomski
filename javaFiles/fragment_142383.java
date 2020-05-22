mapper = new ObjectMapper();
    mapper.addMixInAnnotations(User.class, FirstFormat.class);
    Map<String, User> res = mapper.readValue(json1, new TypeReference<Map<String, User>>() {});
    System.out.println(res.get("user"));        

    mapper = new ObjectMapper();
    mapper.addMixInAnnotations(User.class, SecondFormat.class);
    System.out.println(mapper.readValue(json2, new TypeReference<User>(){}));

    mapper = new ObjectMapper();
    mapper.addMixInAnnotations(User.class, ThirdFormat.class);
    System.out.println(mapper.readValue(json3, new TypeReference<User>(){}));