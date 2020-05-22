ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});

    map.get("monday").get("1").get("subject");
                      ^^^
                      This fails because the result of get("monday") is Object, not Map