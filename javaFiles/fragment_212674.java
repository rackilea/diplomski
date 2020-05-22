try{

  ObjectMapper objectMapper = ...;
  JsonNode jsonNode = objectMapper.readTree(yourJsonString);

} catch(JsonProcessingException e){........}