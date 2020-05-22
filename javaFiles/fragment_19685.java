ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
Map<String,Object> words = mapper.readValue(new File("test.json"), Map.class);
int value = 0;
for (String word : words.keySet()) {
    Map<String, Integer> tags = (Map) words.get(word);
    for (String tag : tags.keySet()) {
        value += tags.get(tag);
    }
}
System.out.println(value); #1161192