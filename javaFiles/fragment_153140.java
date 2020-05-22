String jsonString = "your Json array";
ObjectMapper mapper = new ObjectMapper();
List<Data> objList = mapper.readValue(jsonString, new TypeReference<List<Data>>(){});
for (Data obj : objList) {
     //code.
}