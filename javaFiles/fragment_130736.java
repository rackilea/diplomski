// Make this a singleton, i.e. don't create a new instance on every call!
ObjectMapper objectMapper = new ObjectMapper();

private <T> List<T> mapObjectsToList(
        String objectsListInJson, 
        TypeReference<List<T>> mapType) throws IOException {

    return objectMapper.readValue(objectsListInJson, mapType);
}