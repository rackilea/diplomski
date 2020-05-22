ObjectMapper mapper = new ObjectMapper();

JsonNode root = mapper.readTree(json);

Iterator<String> it = root.fieldNames();
while (it.hasNext()){
    System.out.println(it.next());
}