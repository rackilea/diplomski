byte[] rawJson = new byte[dStream.available()];
TypeReference<Map<String, List<Observation>>> typeRef = 
new TypeReference<Map<String, List<Observation>>>() {};
ObjectMapper mapper = new ObjectMapper();
dStream.readFully(rawJson);                            
map = mapper.readValue(rawJson, typeRef);