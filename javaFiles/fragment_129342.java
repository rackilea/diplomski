Gson gson = new Gson();

Map<String, Map<String, Double>> outerMap = new HashMap<>();

Map<String, Double> innerMap = new HashMap<>();
innerMap.put("1", 1.0);
innerMap.put("2", 2.0);

outerMap.put("key1", innerMap);

String json = gson.toJson(outerMap);

Path path = FileSystems.getDefault().getPath("", "myfile.txt");
Files.write(path, json.getBytes("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

json = new String(Files.readAllBytes(path));

outerMap = gson.fromJson(json, new TypeToken<Map<String, Map<String, Double>>>(){}.getType());

for (Map.Entry<String, Map<String, Double>> outerEntry: outerMap.entrySet()) {
    System.out.println(outerEntry.getKey());
    innerMap = outerEntry.getValue();

    for (Map.Entry<String, Double> innerEntry: innerMap.entrySet()) {
        System.out.println("    " + innerEntry.getKey() + "->" + innerEntry.getValue());
    }
}