JSONParser parser = new JSONParser();
Object obj = parser.parse(new FileReader(jsonFile));
// root object
JSONObject root = (JSONObject) obj;
JSONArray jsonArray = (JSONArray) root.get(productType);
if (jsonArray == null) {
    jsonArray = new JSONArray();
}
Map<String, Object> map = new LinkedHashMap<>(2);
map.put("model", "Model");
map.put("year", 2019);
jsonArray.add(map);

root.put(productType, jsonArray);

FileWriter file = new FileWriter(jsonFile, false);
// use root object
file.append(root.toString());
file.flush();
file.close();