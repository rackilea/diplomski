public static List<Entry> getAllEntries(String jsonString) {        
    List<Entry> entries = new ArrayList<Entry>();                               
        try {
            if (jsonString.length() == 0) {
                throw new Exception("Empty json!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode resultNode = rootNode.findPath("result"); // choose concrete element in JSON array
            if (resultNode.size() > 0) {
                for (int i = 0; i < resultNode.size(); i++) {
                    entries.add(objectMapper.readValue(resultNode.get(i).toString(), Entry.class));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return entries;
}