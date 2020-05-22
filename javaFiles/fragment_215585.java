ObjectMapper mapper = new ObjectMapper();
Map<String, Object> data = mapper.readValue(file, Map.class);
List<Map<String, Object>> items = (List) data.get("items");
for (Map<String, Object> item : items) {
    Map pagemap = (Map) item.get("pagemap");
    List<Map<String, Object>> metatags = (List) pagemap.get("metatags");
    for (Map<String, Object> tag : metatags) {
        String b_title = (String) tag.get("og:title");
        System.out.println(b_title);
    }

}