private static void parseJsonNode(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        JsonNode rootNode = mapper.readTree(new File(BASE_PATH + path));
        Map<String, Object> elementsMap = fillHashMap(rootNode.get("items").get("properties"));
        System.out.println(elementsMap);
    }