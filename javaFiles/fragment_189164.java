Pattern numberPattern = Pattern.compile("\\d+");
Filter filter = filter(where("status").regex(numberPattern));
net.minidev.json.JSONArray test = JsonPath.read("{\"status\": 300}", "$[?].status", filter);

if (!test.isEmpty()) {
    for (Object object : test) {
         System.out.println("Test : " + object.toString());
    }
}