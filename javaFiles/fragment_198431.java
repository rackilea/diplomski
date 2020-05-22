ObjectMapper mapper = new ObjectMapper();
List<Map<String, Object> list = new ArrayList<>()
try (
BufferedReader br = new BufferedReader(new FileReader(new File("test.json")))) {
String line;
while((line = br.readLine()) != null) {
  Map obj = mapper.readValue(line, Map.class);
  list.add(obj)
}