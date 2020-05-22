Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");

    String json = new ObjectMapper().writeValueAsString(map);
    System.out.println(json);