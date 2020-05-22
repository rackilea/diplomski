List<Animal> myList = new ArrayList<Animal>();
myList.add(new Lion("Simba"));
// myList.add(new Lion("Nala"));
myList.add(new Elephant("Dumbo"));
// myList.add(new Elephant("Lucy"));
AnimalList wrapperWrite = new AnimalList(myList);

try {
    ObjectMapper mapper = new ObjectMapper();
    JavaType listJavaType = mapper.getTypeFactory().constructCollectionType(List.class, Animal.class);

    String outputJson = mapper.writerWithType(listJavaType).writeValueAsString(myList);
    System.out.println(outputJson);

    List wrapperRead = mapper.readValue(outputJson, List.class);
    System.out.println("Read recently generated data: " + wrapperRead);

    // Test reading using raw list
    List<Animal> jsonList = mapper.readValue(new FileInputStream( "demo.json"), listJavaType);
    System.out.println("Read from demo.json \ndata: " + jsonList);

    outputJson = mapper.writerWithType(listJavaType).writeValueAsString(jsonList);
    System.out.println(outputJson);

} catch (JsonGenerationException e) {
    System.out.println("Could not generate JSON: " + e.getMessage());
} catch (JsonMappingException e) {
    System.out.println("Invalid JSON Mapping: " + e.getMessage());
} catch (IOException e) {
    System.out.println("File I/O error: ");
}