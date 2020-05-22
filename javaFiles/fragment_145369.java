Configuration config= Configuration.builder()
    .jsonProvider(new JacksonJsonNodeJsonProvider())
    .mappingProvider(new JacksonMappingProvider())
    .build();

JsonNode newJson=JsonPath.using(config).parse(yourActualJSONString).set("$.A[2].A","UPDATED").json();
System.out.println(newJson.toString());