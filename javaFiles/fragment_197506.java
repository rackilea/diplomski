final JSONArray menuObj = new JSONArray("[\n" +
        "    {\n" +
        "        \"id\": \"1\",\n" +
        "        \"item\": \"tea\",\n" +
        "        \"price\": \"7.5\",\n" +
        "        \"image\": \"http://192.168.1.3/CI/images/tea.jpg\",\n" +
        "        \"veg\": \"0\",\n" +
        "        \"category\": \"drinks\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"id\": \"2\",\n" +
        "        \"item\": \"coffee\",\n" +
        "        \"price\": \"10\",\n" +
        "        \"image\": \"http://192.168.1.3/CI/images/coffee.jpg\",\n" +
        "        \"veg\": \"0\",\n" +
        "        \"category\": \"drinks\"\n" +
        "    }\n" +
        "]");
for (int i = 0; i < menuObj.length(); i++){
    final JSONObject row = menuObj.getJSONObject(i);
    System.out.println("imageUrl: " +  row.getString("image"));
    System.out.println("rowString: " +  row);
}