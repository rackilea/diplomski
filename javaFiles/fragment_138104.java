ObjectMapper mapper = new ObjectMapper();
// read JSON from a file
Map<String, Object> map = mapper.readValue(
    new File("c:\\user.json"),
    new TypeReference<Map<String, Object>>() {
});
System.out.println(map.get("name"));
System.out.println(map.get("age"));
@SuppressWarnings("unchecked")
ArrayList<String> list = (ArrayList<String>) map.get("messages");