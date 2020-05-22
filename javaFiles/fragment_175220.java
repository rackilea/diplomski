String kb = "http://api.conceptnet.io/c/en/example";
Document docKb = Jsoup.connect(kb).get();
String json = docKb.body().text();

Gson gson = new Gson();
Map<String, Object> asMap = gson.fromJson(json, Map.class);
List<Map<String, Object>> edges = (List) asMap.get("edges");
for (Map<String, Object> edge : edges) {
    // check that the response contains a surfaceText
    if (edge.containsKey("surfaceText")) {
        // check that the surfaceText value is non-null
        String surfaceText = (String) edge.get("surfaceText");
        if (surfaceText != null) {
            System.out.println(edge.get("surfaceText"));
        }
    }
    if (edge.containsKey("weight")) {
        System.out.println(edge.get("weight"));
    }
}